/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import org.mule.api.transformer.TransformerException;
import org.mule.modules.handshake.client.GenericHandshakeClient;
import org.mule.modules.handshake.client.HandshakeClientProvider;
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

    private final String apiKey;
    private final String securityToken;
    private GenericHandshakeClient<Customer> customersClient;
    private GenericHandshakeClient<Order> ordersClient;
    private GenericHandshakeClient<Item> itemsClient;
    private GenericHandshakeClient<Category> categoriesClient;
    private GenericHandshakeClient<CustomerGroup> customerGroupsClient;
    private GenericHandshakeClient<UserGroup> userGroupsClient;

    public HandshakeClientProviderImpl(final String apiKey, final String securityToken) {
        this.apiKey = apiKey;
        try {
            this.securityToken = new Base64Encoder().doTransform(securityToken, "UTF-8").toString();
        } catch (final TransformerException e) {
            throw new HandshakeAPIException("Couldn't base64-encode your security token");
        }
    }

    public GenericHandshakeClient<Order> getOrdersClient() {
        if (ordersClient == null) {
            ordersClient = new GenericHandshakeClientImpl<Order>(apiKey, securityToken, "orders", new TypeToken<Order>() {}.getType(), new TypeToken<HandshakeAPIResponse<Order>>() {}.getType());
        }
        return ordersClient;
    }

    public GenericHandshakeClient<Customer> getCustomersClient() {
        if (customersClient == null) {
            customersClient = new GenericHandshakeClientImpl<Customer>(apiKey, securityToken, "customers", new TypeToken<Customer>() {}.getType(), new TypeToken<HandshakeAPIResponse<Customer>>() {}.getType());
        }
        return customersClient;
    }

    public GenericHandshakeClient<Item> getItemsClient() {
        if (itemsClient == null) {
            itemsClient = new GenericHandshakeClientImpl<Item>(apiKey, securityToken, "items", new TypeToken<Item>() {}.getType(), new TypeToken<HandshakeAPIResponse<Item>>() {}.getType());
        }
        return itemsClient;
    }

    @Override
    public GenericHandshakeClient<Category> getCategoriesClient() {
        if (categoriesClient == null) {
            categoriesClient = new GenericHandshakeClientImpl<Category>(apiKey, securityToken, "categories", new TypeToken<Category>() {}.getType(), new TypeToken<HandshakeAPIResponse<Category>>() {}.getType());
        }
        return categoriesClient;
    }

    @Override
    public GenericHandshakeClient<CustomerGroup> getCustomerGroupsClient() {
        if (customerGroupsClient == null) {
            customerGroupsClient = new GenericHandshakeClientImpl<CustomerGroup>(apiKey, securityToken, "customer_groups", new TypeToken<CustomerGroup>() {}.getType(), new TypeToken<HandshakeAPIResponse<CustomerGroup>>() {}.getType());
        }
        return customerGroupsClient;
    }

    @Override
    public GenericHandshakeClient<UserGroup> getUserGroupsClient() {
        if (userGroupsClient == null) {
            userGroupsClient = new GenericHandshakeClientImpl<UserGroup>(apiKey, securityToken, "user_groups", new TypeToken<UserGroup>() {}.getType(), new TypeToken<HandshakeAPIResponse<UserGroup>>() {}.getType());
        }
        return userGroupsClient;
    }
}
