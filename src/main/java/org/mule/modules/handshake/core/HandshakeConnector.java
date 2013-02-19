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
import org.mule.api.annotations.display.Placement;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.handshake.client.HandshakeClientProvider;
import org.mule.modules.handshake.client.impl.HandshakeAPIException;
import org.mule.modules.handshake.client.impl.HandshakeClientProviderImpl;

/**
 * Handshake Cloud Connector
 * 
 * Note on creation of resources and references
 * Some creation methods allow to specify nested objects either as new or references to existing.
 * Whenever you want to create a object that references an existing one (for example, a new Order for an existing Customer), you just have to specify the resourceUri of the nested object.
 * <pre>
 * &lt;handshake:create-order&gt;
 *     &lt;handshake:order&gt;
 *         &lt;handshake:customer resourceUri="/api/v2/customers/1"/&gt;
 *     &lt;/handshake:create-order&gt;
 * &lt;/handshake:order&gt;
 * </pre>
 * However, you can also create a nested object alongside the master one.
 * <pre>
 * &lt;handshake:create-order&gt;
 *     &lt;handshake:order&gt;
 *         &lt;handshake:customer id="SOME_ID" name="Some Customer"&gt;
 *             &lt;handshake:bill-to city="Springfiled" stree="742 Evergreen Terrace"/&gt;
 *         &lt;/handshake:customer&gt;
 *     &lt;/handshake:create-order&gt;
 * &lt;/handshake:order&gt;
 * </pre>
 * When you create a new object through the API, the returned value will always contain a resourceUri attribute, which should be stored in your external system for future use as a reference.
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
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-orders-with-filters}
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-orders-with-filters-by-date}
     *
     * @param filters allowed values are: "customerID", "status", "ctime" and "mtime" (for creation and modification times, check operators in http://www.handshake-app.com/help/kb/api/web-services-resources-overview)
     *
     * @return The list of Sales Orders matching the filters
     */
    @Processor
    public List<Order> getOrders(@Optional @Placement(group="Filters") final Map<String, String> filters) {
        return getClientProvider().getOrdersClient().getAll(filters);
    }

    /**
     * Get a {@link org.mule.modules.handshake.core.Order}, given its id
     * 
     * @param resourceUri of the Order to get. The uri is Handshake's uid, as returned by the creation method (like '/api/v2/&lt;resource&gt;/&lt;id&gt;')
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-order}
     *
     * @return the order with the given id or a {@link HandshakeAPIException}, if the Order doesn't exist
     */
    @Processor
    public Order getOrder(final String resourceUri) {
        return getClientProvider().getOrdersClient().getByResourceUri(resourceUri);
    }

    /**
     * Get all customers for the connected account
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-customers}
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-customers-with-filters}
     * @param filters allowed values are: "customerGroup", "userGroup", "ctime" and "mtime" (for creation and modification times, check operators in http://www.handshake-app.com/help/kb/api/web-services-resources-overview)
     * 
     * NOTE: filter values refer to the user-defined IDs, and not to the HandShake id 
     * 
     * @return The list of customers for the connected account
     */
    @Processor
    public List<Customer> getCustomers(@Optional @Placement(group="Filters") final Map<String, String> filters) {
        return getClientProvider().getCustomersClient().getAll(filters);
    }

    /**
     * Get a {@link org.mule.modules.handshake.core.Customer}, given its id
     * 
     * @param id of the Customer to get. The id is the one specified on creation, and not Handshake's uid
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
     * Creates a {@link org.mule.modules.handshake.core.Customer} on Handshake
     * 
     * Take into account than neither the {@link CustomerGroup} nor the {@link UserGroup} can be created alongside the {@link Customer}
     * You can either let them be the default values for your account (by not specifying them), or use their resourceUri property to reference an existing one
     * 
     * @param customer to create. Mandatory fields are ID, name and billTo (which has to be a new Address, and not a reference)
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
     * Edits a {@link org.mule.modules.handshake.core.Customer} on Handshake, given her resourceUri
     * 
     * Take into account than neither the {@link CustomerGroup} nor the {@link UserGroup} can be created alongside the {@link Customer}
     * You can either let them be the default values for your account (by not specifying them), or use their resourceUri property to reference an existing one
     * 
     * @param resourceUri of the Customer to edit
     * @param edited Customer. You should only include those fields that you want to update, specially if referencing existing nested objects (e.g. try not to include billing address information if it hasn't changed) 
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:edit-customer}
     *
     * @return the edited customer
     */
    @Processor
    public Customer editCustomer(final String resourceUri, final Customer edited) {
        return getClientProvider().getCustomersClient().edit(resourceUri, edited);
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
    @Processor
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
    @Processor
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
    @Processor
    public Category createCategory(final Category category) {
        return getClientProvider().getCategoriesClient().create(category);
    }

    /**
     * Creates a {@link org.mule.modules.handshake.core.Order} on handshake
     *
     * @param order to create
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:create-order}
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:create-order-with-new-customer}
     *
     * @return the created order
     */
    @Processor
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
