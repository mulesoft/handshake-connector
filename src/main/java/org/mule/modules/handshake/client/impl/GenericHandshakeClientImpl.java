package org.mule.modules.handshake.client.impl;

import java.lang.reflect.Type;

import org.mule.modules.handshake.client.GenericHandshakeClient;

import com.sun.jersey.api.client.WebResource.Builder;

public class GenericHandshakeClientImpl<T> extends AbstractHandshakeClient implements GenericHandshakeClient<T> {

    private final String apiKey;
    private final String resourcePath;
    private final Type elementType;

    public GenericHandshakeClientImpl(final String apiKey, final String resourcePath, final Type elementType) {
        this.apiKey = apiKey;
        this.resourcePath = resourcePath;
        this.elementType = elementType;
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

}
