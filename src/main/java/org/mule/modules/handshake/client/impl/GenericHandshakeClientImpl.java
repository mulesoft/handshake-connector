/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mule.modules.handshake.client.GenericHandshakeClient;

import com.sun.jersey.api.client.WebResource.Builder;

public class GenericHandshakeClientImpl<T> extends AbstractHandshakeClient implements GenericHandshakeClient<T> {

    private final String apiKey;
    private final String resourcePath;
    private final Type elementType;
    private final Type responseElementType;
    private static Pattern RESOURCE_PATTERN = Pattern.compile("^/api/v2/.*/(\\d+)$");

    public GenericHandshakeClientImpl(final String apiKey, final String resourcePath, final Type elementType, final Type responseElementType) {
        this.apiKey = apiKey;
        this.resourcePath = resourcePath;
        this.elementType = elementType;
        this.responseElementType = responseElementType;
    }

    @Override
    protected StringBuilder extendGetBaseUrl(final StringBuilder baseUrl) {
        return baseUrl.append(this.resourcePath);
    }

    @Override
    public T create(final T t) {
        final Builder builder = getBuilder(apiKey, getBaseURL(), null);
        return this.post(builder, elementType, elementType, t);
    }

    @Override
    public T update(final String resourceUri, final T edited) {
        final Builder builder = getBuilder(apiKey, this.detailUrl(resourceUri), null);
        return this.update(builder, elementType, edited);
    }

    @Override
    public HandshakeListing<T> getAll(final Map<String, String> filters, final Integer limit, final Integer offset) {
        final Map<String, String> params = new HashMap<String, String>();
        if (filters != null) {
            params.putAll(filters);
        }
        if (limit != null) {
            params.put("limit", limit.toString());
        }
        if (offset != null) {
            params.put("offset", offset.toString());
        }
        final Builder builder = getBuilder(apiKey, getBaseURL(), params);
        return this.get(builder, responseElementType);
    }

    @Override
    public T getById(final String id) {
        @SuppressWarnings("serial")
        final Builder builder = getBuilder(apiKey, getBaseURL(), new HashMap<String, String>() {{put("id", id);}});
        final HandshakeListing<T> response = this.get(builder, responseElementType);
        if (!response.getResults().isEmpty()) {
            return response.getResults().get(0);
        } else {
            return null;
        }
    }

    @Override
    public T getByResourceUri(final String resourceUri) {
        final Builder builder = getBuilder(apiKey, this.detailUrl(resourceUri), null);
        return this.singleGet(builder, elementType);
    }

    /**
     * Extracts the resource id from a resourceUri
     * @param resourceUri from which to extract the resource ID
     * @throws IllegalArgumentException if the resourceUri is not well formed
     * @return the id
     */
    protected static String extractIdFromResourceUri(final String resourceUri) {
        Matcher matcher = RESOURCE_PATTERN.matcher(resourceUri);
        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException("The given resourceUri is not valid: " + resourceUri);
        }
    }

    private String detailUrl(final String resourceUri) {
        return new StringBuilder(getBaseURL()).append("/").append(extractIdFromResourceUri(resourceUri)).toString();
    }
}
