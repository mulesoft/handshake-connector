/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.security.KeyStore.Builder;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.mule.modules.handshake.client.serialization.BigDecimalAsStringSerializer;
import org.mule.modules.handshake.client.serialization.HandshakeCustomerSerializer;
import org.mule.modules.handshake.client.serialization.HandshakeItemSerializer;
import org.mule.modules.handshake.client.serialization.HandshakeOrderSerializer;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.HandshakeAPIResponse;
import org.mule.modules.handshake.core.Item;
import org.mule.modules.handshake.core.Order;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Base class for all the service client in this project. The class handles:
 * 
 * <ul>
 * 	<li>base URL creation</li>
 *  <li>creation of the Jersey client</li>
 *  <li>set up of basic authentication headers</li>
 *  <li>read of files from input streams</li>
 *  <li>string serialization of the responses</li>
 * </ul>
 */
public abstract class AbstractHandshakeClient {

    private static final String DEFAULT_BASE_URL = "https://preview.handshake-app.com/api/v2/";

    private String baseUrl = "";

    protected final Gson gson;

    public AbstractHandshakeClient() {
        final GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Order.class, new HandshakeOrderSerializer());
        builder.registerTypeAdapter(Customer.class, new HandshakeCustomerSerializer());
        builder.registerTypeAdapter(Item.class, new HandshakeItemSerializer());
        builder.registerTypeAdapter(BigDecimal.class, new BigDecimalAsStringSerializer());
        this.gson = builder.create();
    }

    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Builds the base URL for this service.
     * 
     * @return the base URL with no final "/".
     */
    protected String getBaseURL() {
        final StringBuilder baseUrlBuilder = new StringBuilder();

        if (StringUtils.isNotEmpty(baseUrl)) {
            baseUrlBuilder.append(this.baseUrl);
        } else {
            baseUrlBuilder.append(DEFAULT_BASE_URL);
        }

        return extendGetBaseUrl(baseUrlBuilder).toString();
    }

    /**
     * This method is called by getBaseURL for the user to extend the base URL
     * of its ServiceClient implementation.
     * 
     * @param baseUrl a builder with the Base Url
     * @return the builder, with the extended content as needed
     */
    protected abstract StringBuilder extendGetBaseUrl(final StringBuilder baseUrl);

    /**
     * Creates a {@link Builder}
     * 
     * @param user for authentication
     * @param password for authentication
     * @param url the URL to be hit by the client
     * @param queryParameters a map containing all the query parameters
     * @return the builder.
     */
    protected WebResource.Builder getBuilder(final String user, final String password, final String url, final Map<String, String> queryParameters) {

        final ClientConfig clientConfig = getJerseyClientConfiguration();

        Client client = null;
        if (clientConfig == null) {
            client = Client.create();
        } else {
            client = Client.create(clientConfig);
        }

        client.addFilter(getBasicAuthenticationFilter(user, password));
        client.addFilter(new LoggingFilter());

        final WebResource wr = client.resource(url);
        final MultivaluedMap<String, String> actualQueryParameters = mapToMultivaluedMap(queryParameters);

        // We want all request to return whole objects where possible, instead of just references
        if (!actualQueryParameters.containsKey("full")) {
            actualQueryParameters.putSingle("full", "true");
        }
        return wr.queryParams(actualQueryParameters).type(MediaType.APPLICATION_JSON_TYPE);
    }

    protected <T> HandshakeListing<T> get(final WebResource.Builder resourceBuilder, final Type type) {
        final ClientResponse clientResponse = resourceBuilder.get(ClientResponse.class);
        final HandshakeAPIResponse<T> response = processResponse(clientResponse, type);
        return HandshakeListing.fromAPIResponse(response);
    }

    protected <T> T singleGet(final WebResource.Builder resourceBuilder, final Type type) {
        final ClientResponse clientResponse = resourceBuilder.get(ClientResponse.class);
        return processResponse(clientResponse, type);
    }

    protected <T> T post(final WebResource.Builder resourceBuilder, final Type requestType, final Type responseType, final Object params) {
        final String paramsString = gson.toJson(params, requestType);
        final ClientResponse clientResponse = resourceBuilder.post(ClientResponse.class, paramsString);
        return processResponse(clientResponse, responseType);
    }

    protected <T> T update(final WebResource.Builder resourceBuilder, final Type objectType, final T edited) {
        final String paramsString = gson.toJson(edited, objectType);
        final ClientResponse clientResponse = resourceBuilder.put(ClientResponse.class, paramsString);
        return processResponse(clientResponse, objectType);
    }

    /**
     * @param clientResponse returned by the invocation
     * @param responseType of the expected response
     * @return the response, or an Exception if something bad happened
     */
    private <T> T processResponse(final ClientResponse clientResponse, final Type responseType) {
        final String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            throw new HandshakeAPIException(response);
        }

        try {
            return parseJson(response, responseType);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is called by getBuilder before the creation of the
     * {@link Client}. The {@link ClientConfig} is used to create the
     * {@link Client}.
     * 
     * @return
     */
    protected ClientConfig getJerseyClientConfiguration() {
        return null;
    }

    /**
     * Creates a {@link HTTPBasicAuthFilter} for HTTP basic authentication.
     * 
     * @param user
     * @param password
     * @return a {@link HTTPBasicAuthFilter} to be added to the {@link Client}
     */
    private HTTPBasicAuthFilter getBasicAuthenticationFilter(final String user, final String password) {
        return new HTTPBasicAuthFilter(user, password);
    }

    /**
     * Transform a map in a {@link MultivaluedMap} which is needed by Jersey to
     * send query parameters. It also validate that not empty parameters are
     * being send.
     * 
     * @param map
     *            the map of query parameters
     * @return the same map in an {@link MultivaluedMap} object.
     */
    protected MultivaluedMap<String, String> mapToMultivaluedMap(final Map<String, String> map) {
        final MultivaluedMap<String, String> multivaluedMap = new MultivaluedMapImpl();

        if (map != null && !map.isEmpty()) {
            for (final String key : map.keySet()) {
                multivaluedMap.add(key, map.get(key));
            }
        }

        return multivaluedMap;
    }

    protected String readResponseFromClientResponse(final ClientResponse clientResponse) {
        try {
            return IOUtils.toString(clientResponse.getEntityInputStream());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }        
    }

    /**
     * Parse JSON to specified type
     *
     * @param <V> type of the object to obtain
     * @param string JSON-formatted string to parse
     * @param type of the object to obtain
     * @return parsed object
     * @throws IOException if the string is not JSON-formatted
     */
    protected <V> V parseJson(final String string, final Type type) throws IOException {        
        try {
            return gson.fromJson(string, type);
        } catch (final JsonParseException jpe) {
            final IOException ioe = new IOException("Parse exception converting JSON to object"); //$NON-NLS-1$
            ioe.initCause(jpe);
            throw ioe;
        }
    }

}