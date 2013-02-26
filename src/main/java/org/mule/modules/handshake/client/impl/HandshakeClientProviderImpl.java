/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
    public HandshakeClientProviderImpl(final String apiKey, final String securityToken) {
        try {
            final String encodedSecurityToken = StringUtils.isBlank(securityToken) ? "" : new Base64Encoder().doTransform(securityToken, "UTF-8").toString();
            this.clients = new HashMap<Class<?>, GenericHandshakeClient<?>>() {{
                put(Address.class, new GenericHandshakeClientImpl<Address>(apiKey, encodedSecurityToken, "addresses", new TypeToken<Address>() {}.getType(), new TypeToken<HandshakeAPIResponse<Address>>() {}.getType()));
                put(Order.class, new GenericHandshakeClientImpl<Order>(apiKey, encodedSecurityToken, "orders", new TypeToken<Order>() {}.getType(), new TypeToken<HandshakeAPIResponse<Order>>() {}.getType()));
                put(Customer.class, new GenericHandshakeClientImpl<Customer>(apiKey, encodedSecurityToken, "customers", new TypeToken<Customer>() {}.getType(), new TypeToken<HandshakeAPIResponse<Customer>>() {}.getType()));
                put(Item.class, new GenericHandshakeClientImpl<Item>(apiKey, encodedSecurityToken, "items", new TypeToken<Item>() {}.getType(), new TypeToken<HandshakeAPIResponse<Item>>() {}.getType()));
                put(Category.class, new GenericHandshakeClientImpl<Category>(apiKey, encodedSecurityToken, "categories", new TypeToken<Category>() {}.getType(), new TypeToken<HandshakeAPIResponse<Category>>() {}.getType()));
                put(CustomerGroup.class, new GenericHandshakeClientImpl<CustomerGroup>(apiKey, encodedSecurityToken, "customer_groups", new TypeToken<CustomerGroup>() {}.getType(), new TypeToken<HandshakeAPIResponse<CustomerGroup>>() {}.getType()));
                put(UserGroup.class, new GenericHandshakeClientImpl<UserGroup>(apiKey, encodedSecurityToken, "user_groups", new TypeToken<UserGroup>() {}.getType(), new TypeToken<HandshakeAPIResponse<UserGroup>>() {}.getType()));
            }};
        } catch (final TransformerException e) {
            throw new HandshakeAPIException("Couldn't base64-encode your security token");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> GenericHandshakeClient<T> getClient(Class<T> type) {
        return (GenericHandshakeClient<T>) this.clients.get(type);
    }
}
