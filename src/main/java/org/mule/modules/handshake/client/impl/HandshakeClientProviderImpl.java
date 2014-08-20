/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.handshake.client.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mule.api.transformer.TransformerException;
import org.mule.modules.handshake.client.GenericHandshakeClient;
import org.mule.modules.handshake.client.HandshakeClientProvider;
import org.mule.modules.handshake.core.Address;
import org.mule.modules.handshake.core.Category;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.CustomerGroup;
import org.mule.modules.handshake.core.HandshakeAPIResponse;
import org.mule.modules.handshake.core.Item;
import org.mule.modules.handshake.core.Order;
import org.mule.modules.handshake.core.UserGroup;
import org.mule.transformer.codec.Base64Encoder;

import com.google.gson.reflect.TypeToken;

public class HandshakeClientProviderImpl implements HandshakeClientProvider {

    private final Map<Class<?>, GenericHandshakeClient<?>> clients;

    @SuppressWarnings("serial")
    public HandshakeClientProviderImpl(final String baseUrl, final String apiKey, final String securityToken, final String antiThrottleKey) {
        try {
            final String encodedSecurityToken = StringUtils.isBlank(securityToken) ? "" : new Base64Encoder().doTransform(securityToken, "UTF-8").toString();
            this.clients = new HashMap<Class<?>, GenericHandshakeClient<?>>() {{
                put(Address.class, new GenericHandshakeClientImpl<Address>(baseUrl, apiKey, encodedSecurityToken, antiThrottleKey, "addresses", new TypeToken<Address>() {}.getType(), new TypeToken<HandshakeAPIResponse<Address>>() {}.getType()));
                put(Order.class, new GenericHandshakeClientImpl<Order>(baseUrl, apiKey, encodedSecurityToken, antiThrottleKey, "orders", new TypeToken<Order>() {}.getType(), new TypeToken<HandshakeAPIResponse<Order>>() {}.getType()));
                put(Customer.class, new GenericHandshakeClientImpl<Customer>(baseUrl, apiKey, encodedSecurityToken, antiThrottleKey, "customers", new TypeToken<Customer>() {}.getType(), new TypeToken<HandshakeAPIResponse<Customer>>() {}.getType()));
                put(Item.class, new GenericHandshakeClientImpl<Item>(baseUrl, apiKey, encodedSecurityToken, antiThrottleKey, "items", new TypeToken<Item>() {}.getType(), new TypeToken<HandshakeAPIResponse<Item>>() {}.getType()));
                put(Category.class, new GenericHandshakeClientImpl<Category>(baseUrl, apiKey, encodedSecurityToken, antiThrottleKey, "categories", new TypeToken<Category>() {}.getType(), new TypeToken<HandshakeAPIResponse<Category>>() {}.getType()));
                put(CustomerGroup.class, new GenericHandshakeClientImpl<CustomerGroup>(baseUrl, apiKey, encodedSecurityToken, antiThrottleKey, "customer_groups", new TypeToken<CustomerGroup>() {}.getType(), new TypeToken<HandshakeAPIResponse<CustomerGroup>>() {}.getType()));
                put(UserGroup.class, new GenericHandshakeClientImpl<UserGroup>(baseUrl, apiKey, encodedSecurityToken, antiThrottleKey, "user_groups", new TypeToken<UserGroup>() {}.getType(), new TypeToken<HandshakeAPIResponse<UserGroup>>() {}.getType()));
            }};
        } catch (final TransformerException e) {
            throw new HandshakeAPIException("Couldn't base64-encode your security token");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> GenericHandshakeClient<T> getClient(final Class<T> type) {
        return (GenericHandshakeClient<T>) this.clients.get(type);
    }
}
