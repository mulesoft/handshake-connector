/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 **/

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.modules.handshake.core;

import java.util.List;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.modules.handshake.client.CustomersClient;
import org.mule.modules.handshake.client.OrdersClient;
import org.mule.modules.handshake.client.impl.CustomersClientImpl;
import org.mule.modules.handshake.client.impl.OrdersClientImpl;

/**
 * Cloud Connector
 *
 * @author marianosimone
 */
@Connector(name="handshake", schemaVersion="1.0-SNAPSHOT")
public class HandshakeConnector {

    private String apiKey;

    private OrdersClient ordersClient;
    private CustomersClient customersClient;

    /**
     * Connect
     *
     * @param apiKey the API key for the user
     * @throws ConnectionException
     */
    @Connect
    public void connect(@ConnectionKey String apiKey)
        throws ConnectionException {
        this.apiKey = apiKey;
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        // Nothing to do here
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        // TODO: Use a factory and determine based on that?
        return true;
    }

    /**
     * The key to identify the connection
     */
    @ConnectionIdentifier
    public String connectionId() {
        return apiKey;
    }

    /**
     * Custom processor
     *
     * {@sample.xml ../../../doc/Handshake-connector.xml.sample handshake:my-processor}
     *
     * @param content Content to be processed
     * @return Some string
     */
    @Processor
    public String myProcessor(String content) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return content;
    }

    public List<Order> getOrders() {
        return getOrdersClient().getOrders();
    }

    public List<Customer> getCustomers() {
        return getCustomersClient().getCustomers();
    }

    private OrdersClient getOrdersClient() {
        if (ordersClient == null) {
            ordersClient = new OrdersClientImpl(apiKey);
        }
        return ordersClient;
    }

    private CustomersClient getCustomersClient() {
        if (customersClient == null) {
            customersClient = new CustomersClientImpl(apiKey);
        }
        return customersClient;
    }
}