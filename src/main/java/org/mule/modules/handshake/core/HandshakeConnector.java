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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.handshake.client.HandshakeClientProvider;
import org.mule.modules.handshake.client.impl.HandshakeClientProviderImpl;

/**
 * Cloud Connector
 *
 * @author marianosimone
 */
@Connector(name="handshake", schemaVersion="1.0-SNAPSHOT")
public class HandshakeConnector {

    private String apiKey;
    private HandshakeClientProvider clientProvider;

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
        return clientProvider != null;
    }

    /**
     * The key to identify the connection
     */
    @ConnectionIdentifier
    public String connectionId() {
        return apiKey;
    }

    /**
     * Get Sales Orders for the connected account
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-orders}
     *
     *
     * @param filters allowed values are: "customerID", "status" and "ctime" (for creation time, check operators in http://www.handshake-app.com/help/kb/api/web-services-resources-overview)
     *
     * @return The list of Sales Orders matching the filters
     */
    @Processor
    public List<Order> getOrders(@Optional final Map<String, String> filters) {
        return getClientProvider().getOrdersClient().getAll(filters);
    }

    /**
     * Get all customers for the connected account
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-customers}
     *
     * @return The list of customers for the connected account
     */
    @Processor
    public List<Customer> getCustomers() {
        return getClientProvider().getCustomersClient().getAll(null);
    }

    /**
     * Get a {@link org.mule.modules.handshake.core.Customer}, given its id
     * 
     * @param id of the Customer to get
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-customer}
     *
     * @return the customer with the given id, or null if it doesn't exist
     */
    @Processor
    public Customer getCustomer(final String id) {
        return getClientProvider().getCustomersClient().getById(id);
    }

    /**
     * Creates a {@link org.mule.modules.handshake.core.Customer} on handshake
     * 
     * @param customer to create
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:create-customer}
     *
     * @return the created customer
     */
    @Processor
    public Customer createCustomer(final Customer customer) {
        return getClientProvider().getCustomersClient().create(customer);
    }

    /**
     * Creates a {@link org.mule.modules.handshake.core.Item} on handshake
     * 
     * @param item to create
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:create-item}
     *
     * @return the created item
     */
    //TODO: Keep or remove and let people create a list for one element?
    //@Processor
    public Item createItem(final Item item) {
        return getClientProvider().getItemsClient().create(item);
    }

    /**
     * Creates {@link org.mule.modules.handshake.core.Item}s on handshake
     * 
     * @param items to create
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:create-items}
     *
     * @return a list of the items created (if everything is ok, it should match the provided list)
     */
    //@Processor
    public List<Item> createItems(final List<Item> items) {
        final List<Item> createdItems = new ArrayList<Item>(items.size());
        for (final Item item: items) {
            createdItems.add(this.createItem(item));
        }
        return createdItems;
    }

    /**
     * Creates a {@link org.mule.modules.handshake.core.Category} on handshake
     * 
     * @param category to create
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:create-category}
     *
     * @return the created category
     */
    //@Processor
    public Category createCategory(final Category category) {
        return getClientProvider().getCategoriesClient().create(category);
    }

    /**
     * Creates a {@link org.mule.modules.handshake.core.Order} on handshake
     *
     * @param order to create
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:create-order}
     *
     * @return the created order
     */
    //@Processor
    public Order createOrder(final Order order) {
        return getClientProvider().getOrdersClient().create(order);
    }

    public HandshakeClientProvider getClientProvider() {
        if (clientProvider == null) {
            clientProvider = new HandshakeClientProviderImpl(apiKey);
        }
        return clientProvider;
    }

}
