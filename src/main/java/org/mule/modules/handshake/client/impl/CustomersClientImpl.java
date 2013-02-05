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
    @SuppressWarnings("serial")
    public Customer getCustomer(final String id) {
        final Builder builder = getBuilder(apiKey, getBaseURL(), new HashMap<String, String>() {{put("id", id);}});
        final HandshakeAPIResponse<Customer> response = this.get(builder, GET_RESPONSE_TYPE);
        if (!response.getObjects().isEmpty()) {
            return response.getObjects().get(0);
        } else {
            return null;
        }
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + "customers/";
    }
}
