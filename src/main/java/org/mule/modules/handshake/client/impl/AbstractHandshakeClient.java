package org.mule.modules.handshake.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.security.KeyStore.Builder;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.HandshakeAPIResponse;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
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

    private static final String DEFAULT_BASE_URL = "https://app.handshake-app.com/api/v2/";

    private String baseUrl = "";

    protected Gson gson = new Gson();

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Builds the base URL for this service.
     * 
     * @return the base URL with no final "/".
     */
    protected String getBaseURL() {
        final StringBuilder baseUrlBuilder = new StringBuilder(100);

        if (StringUtils.isNotEmpty(baseUrl)) {
            baseUrlBuilder.append(this.baseUrl);
        } else {
            baseUrlBuilder.append(DEFAULT_BASE_URL);
        }

        return extendGetBaseUrl(baseUrlBuilder.toString());
    }

    /**
     * This method is called by getBaseURL for the user to extend the base URL
     * of its ServiceClient implementation.
     * 
     * @param baseUrl
     *            the URL created by getBaseURL
     * @return the enhanced base URL
     */
    protected abstract String extendGetBaseUrl(String baseUrl);

    /**
     * Creates a {@link Builder}
     * 
     * @param url
     *            the URL to be hit by the client
     * @param queryParameters
     *            a map containing all the query parameters
     * @return the builder.
     */
    protected WebResource.Builder getBuilder(String user, String url,
            Map<String, String> queryParameters) {

        ClientConfig clientConfig = getJerseyClientConfiguration();

        Client client = null;
        if (clientConfig == null) {
            client = Client.create();
        } else {
            client = Client.create(clientConfig);
        }

        client.addFilter(getBasicAuthenticationFilter(user, ""));

        WebResource wr = client.resource(url);

        MultivaluedMap<String, String> actualQueryParameters = mapToMultivaluedMap(queryParameters);

        if (actualQueryParameters.isEmpty()) {
            return wr.type(MediaType.APPLICATION_JSON_TYPE);
        } else {
            return wr.queryParams(actualQueryParameters).type(MediaType.APPLICATION_JSON_TYPE);
        }
    }

    protected <T> HandshakeAPIResponse<T> get(final WebResource.Builder resourceBuilder, final Type type) {
        ClientResponse clientResponse = resourceBuilder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            // TODO: Handle
            throw new RuntimeException(response);
            //return Arrays.asList(response);
        }

        try {
            return parseJson(response, type);
        } catch (IOException e) {
            // TODO: Handle
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
    private HTTPBasicAuthFilter getBasicAuthenticationFilter(String user, String password) {
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
    protected MultivaluedMap<String, String> mapToMultivaluedMap(Map<String, String> map) {
        MultivaluedMap<String, String> multivaluedMap = new MultivaluedMapImpl();

        if (map != null && !map.isEmpty()) {
            for (String key : map.keySet()) {
                multivaluedMap.add(key, map.get(key));
            }
        }

        return multivaluedMap;
    }

    protected String readResponseFromClientResponse(ClientResponse clientResponse) {
        return readInputStreamToString(clientResponse.getEntityInputStream());
    }

    protected String readInputStreamToString(InputStream inputStream) {
        try {
            return IOUtils.toString(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }        
    }

    /**
     * Parse JSON to specified type
     *
     * @param <V>
     * @param string
     * @param type
     * @return parsed type
     * @throws IOException
     */
    protected <V> V parseJson(final String string, final Type type) throws IOException {        
        try {
            return gson.fromJson(string, type);
        } catch (JsonParseException jpe) {
            IOException ioe = new IOException("Parse exception converting JSON to object"); //$NON-NLS-1$
            ioe.initCause(jpe);
            throw ioe;
        }
    }

}