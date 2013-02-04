package org.mule.modules.handshake.client.impl;

import java.util.List;

import java.lang.reflect.Type;
import org.mule.modules.handshake.client.CustomersClient;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.HandshakeAPIResponse;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.WebResource.Builder;

public class CustomersClientImpl extends AbstractHandshakeClient implements CustomersClient {
    private static final Type GET_RESPONSE_TYPE = new TypeToken<HandshakeAPIResponse<Customer>>() {}.getType();

    private String apiKey;

    public CustomersClientImpl(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public List<Customer> getCustomers() {
        final Builder builder = getBuilder(apiKey, getBaseURL(), null);
        final HandshakeAPIResponse<Customer> response = this.get(builder, GET_RESPONSE_TYPE);
        return response.getObjects();
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + "customers/";
    }
}
