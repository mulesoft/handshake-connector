/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import org.mule.modules.handshake.client.CustomersClient;
import org.mule.modules.handshake.client.HandshakeClientProvider;
import org.mule.modules.handshake.client.ItemsClient;
import org.mule.modules.handshake.client.OrdersClient;

public class HandshakeClientProviderImpl implements HandshakeClientProvider {

    private final String apiKey;
    private CustomersClient customersClient;
    private OrdersClient ordersClient;
    private ItemsClient itemsClient;

    public HandshakeClientProviderImpl(final String apiKey) {
        this.apiKey = apiKey;
    }

    public OrdersClient getOrdersClient() {
        if (ordersClient == null) {
            ordersClient = new OrdersClientImpl(apiKey);
        }
        return ordersClient;
    }

    public CustomersClient getCustomersClient() {
        if (customersClient == null) {
            customersClient = new CustomersClientImpl(apiKey);
        }
        return customersClient;
    }

    public ItemsClient getItemsClient() {
        if (itemsClient == null) {
            itemsClient = new ItemsClientImpl(apiKey);
        }
        return itemsClient;
    }
}
