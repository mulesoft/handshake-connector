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
import java.util.List;
import java.util.Map;

import org.mule.modules.handshake.client.OrdersClient;
import org.mule.modules.handshake.core.HandshakeAPIResponse;
import org.mule.modules.handshake.core.Order;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.WebResource.Builder;

public class OrdersClientImpl extends AbstractHandshakeClient implements OrdersClient {
    private static final Type GET_RESPONSE_TYPE = new TypeToken<HandshakeAPIResponse<Order>>() {}.getType();

    private final String apiKey;

	public OrdersClientImpl(final String apiKey) {
	    this.apiKey = apiKey;
	}

    @Override
    public List<Order> getOrders() {
        return getOrders(null);
    }

    @Override
    public List<Order> getOrders(final Map<String, String> filters) {
        final Builder builder = getBuilder(apiKey, getBaseURL(), filters);
        final HandshakeAPIResponse<Order> response = this.get(builder, GET_RESPONSE_TYPE);
        return response.getObjects();
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + "orders/";
    }

}
