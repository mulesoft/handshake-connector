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
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mule.modules.handshake.client.GenericHandshakeClient;
import org.mule.modules.handshake.core.HandshakeAPIResponse;

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
    protected String extendGetBaseUrl(final String baseUrl) {
        return baseUrl + this.resourcePath + "/";
    }

    @Override
    public T create(final T t) {
        final Builder builder = getBuilder(apiKey, getBaseURL(), null);
        return this.post(builder, elementType, elementType, t);
    }

    @Override
    public List<T> getAll(final Map<String, String> filters) {
        final Builder builder = getBuilder(apiKey, getBaseURL(), filters);
        final HandshakeAPIResponse<T> response = this.get(builder, responseElementType);
        return response.getObjects();
    }

    @Override
    public T getById(final String id) {
        @SuppressWarnings("serial")
        final Builder builder = getBuilder(apiKey, getBaseURL(), new HashMap<String, String>() {{put("id", id);}});
        final HandshakeAPIResponse<T> response = this.get(builder, responseElementType);
        if (!response.getObjects().isEmpty()) {
            return response.getObjects().get(0);
        } else {
            return null;
        }
    }

    @Override
    public T getByResourceUri(final String resourceUri) {
        Matcher matcher = RESOURCE_PATTERN.matcher(resourceUri);
        if (matcher.matches()) {
            final Builder builder = getBuilder(apiKey, getBaseURL() + "/" + matcher.group(1), null);
            return this.singleGet(builder, elementType);
        } else {
            throw new IllegalArgumentException("The given resourceUri is not valid: " + resourceUri);
        }
    }
}
