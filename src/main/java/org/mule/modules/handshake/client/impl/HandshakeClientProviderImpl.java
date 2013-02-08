/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import org.mule.modules.handshake.client.GenericHandshakeClient;
import org.mule.modules.handshake.client.HandshakeClientProvider;
import org.mule.modules.handshake.core.Category;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.HandshakeAPIResponse;
import org.mule.modules.handshake.core.Item;
import org.mule.modules.handshake.core.Order;

import com.google.gson.reflect.TypeToken;

public class HandshakeClientProviderImpl implements HandshakeClientProvider {

    private final String apiKey;
    private GenericHandshakeClient<Customer> customersClient;
    private GenericHandshakeClient<Order> ordersClient;
    private GenericHandshakeClient<Item> itemsClient;
    private GenericHandshakeClient<Category> categoriesClient;

    public HandshakeClientProviderImpl(final String apiKey) {
        this.apiKey = apiKey;
    }

    public GenericHandshakeClient<Order> getOrdersClient() {
        if (ordersClient == null) {
            ordersClient = new GenericHandshakeClientImpl<Order>(apiKey, "orders", new TypeToken<Order>() {}.getType(), new TypeToken<HandshakeAPIResponse<Order>>() {}.getType());
        }
        return ordersClient;
    }

    public GenericHandshakeClient<Customer> getCustomersClient() {
        if (customersClient == null) {
            customersClient = new GenericHandshakeClientImpl<Customer>(apiKey, "customers", new TypeToken<Customer>() {}.getType(), new TypeToken<HandshakeAPIResponse<Customer>>() {}.getType());
        }
        return customersClient;
    }

    public GenericHandshakeClient<Item> getItemsClient() {
        if (itemsClient == null) {
            itemsClient = new GenericHandshakeClientImpl<Item>(apiKey, "items", new TypeToken<Item>() {}.getType(), new TypeToken<HandshakeAPIResponse<Item>>() {}.getType());
        }
        return itemsClient;
    }

    @Override
    public GenericHandshakeClient<Category> getCategoriesClient() {
        if (categoriesClient == null) {
            categoriesClient = new GenericHandshakeClientImpl<Category>(apiKey, "categories", new TypeToken<Category>() {}.getType(), new TypeToken<HandshakeAPIResponse<Category>>() {}.getType());
        }
        return categoriesClient;
    }

}
