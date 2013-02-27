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
import org.mule.api.annotations.display.Password;
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
//@RequiresEnterpriseLicense
@Connector(name="handshake", schemaVersion="1.0-SNAPSHOT", friendlyName="Handshake")
public class HandshakeConnector {

    private String apiKey;
    private String securityToken;
    private HandshakeClientProvider clientProvider;

    /**
     * Connect
     *
     * @param apiKey the API key for the user
     * @param securityToken used for sensitive data encryption. Please refer to http://www.handshake-app.com/help/kb/api/api-authentication
     * @throws ConnectionException
     */
    @Connect
    public void connect(@ConnectionKey final String apiKey, @Optional @Password final String securityToken)
        throws ConnectionException {
        this.apiKey = apiKey;
        this.securityToken = securityToken;
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
     * Find all Sales Orders for the connected account that match the filters
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:find-orders}
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:find-orders-with-filters}
     *
     * @param filters allowed values are: "customerID", "status", "ctime" and "mtime" (for creation and modification times, check operators in http://www.handshake-app.com/help/kb/api/web-services-resources-overview)
     * 
     * @return an Iterable of all the Sales Orders matching the filters
     */
    @Processor
    public Iterable<Order> findOrders(@Optional @Placement(group="Filters") final Map<String, String> filters) {
        return getClientProvider().getClient(Order.class).getAll(filters);
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
        return getClientProvider().getClient(Order.class).getByResourceUri(resourceUri);
    }

    /**
     * Find all customers for the connected account that match the filters
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:find-customers}
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:find-customers-with-filters}
     * @param filters allowed values are: "customerGroup", "userGroup", "ctime" and "mtime" (for creation and modification times, check operators in http://www.handshake-app.com/help/kb/api/web-services-resources-overview)
     * NOTE: filter values refer to the user-defined IDs, and not to the HandShake id 
     * 
     * @return an Iterable of all the Customers matching the filters
     */
    @Processor
    public Iterable<Customer> findCustomers(@Optional @Placement(group="Filters") final Map<String, String> filters) {
        return getClientProvider().getClient(Customer.class).getAll(filters);
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
        return getClientProvider().getClient(Customer.class).getById(id);
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
        return getClientProvider().getClient(Customer.class).create(customer);
    }

    /**
     * Updates a {@link org.mule.modules.handshake.core.Customer} on Handshake, given her resourceUri
     * 
     * Take into account than neither the {@link CustomerGroup} nor the {@link UserGroup} can be created alongside the {@link Customer}
     * You can either let them be the default values for your account (by not specifying them), or use their resourceUri property to reference an existing one
     * 
     * @param resourceUri of the Customer to update (if you skip this, you should include the resourceUri attribute in the customer)
     * @param customer with the changes to update. You should only include those fields that you want to update, specially if referencing existing nested objects (e.g. try not to include billing address information if it hasn't changed) 
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:update-customer}
     *
     * @return the updated customer
     */
    @Processor
    public Customer updateCustomer(@Optional final String resourceUri, final Customer customer) {
        return getClientProvider().getClient(Customer.class).update(resourceUri, customer);
    }

    /**
     * Get all items for the connected account that match the filters
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:find-items}
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:find-items-with-filters}
     * @param filters to apply. Allowed filters are category (by Handshake id), manufacturer (by Handshake id), order (to get items from a specific Order), search (only items with a sku or name that match will be returned), sku (you'll get either 1 or 0 results)
     *
     * @return An iterable of items for the connected account that match the filters
     */
    @Processor
    public Iterable<Item> findItems(@Optional @Placement(group="Filters") final Map<String, String> filters) {
        return getClientProvider().getClient(Item.class).getAll(filters);
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
        return getClientProvider().getClient(Item.class).create(item);
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
     * Updates a {@link org.mule.modules.handshake.core.Item} on Handshake, given its resourceUri
     * 
     * @param resourceUri of the Item to edit (if you skip this, you should include the resourceUri attribute in the item)
     * @param item with the changes to update. You should only include those fields that you want to update, specially if referencing existing nested objects
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:update-item}
     *
     * @return the updated item
     */
    @Processor
    public Item updateItem(@Optional final String resourceUri, final Item item) {
        return getClientProvider().getClient(Item.class).update(resourceUri, item);
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
        return getClientProvider().getClient(Category.class).create(category);
    }

    /**
     * Get a {@link org.mule.modules.handshake.core.Category}, given its id
     * 
     * @param id of the Category to get. The id is the one specified on creation, and not Handshake's uid
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-category}
     *
     * @return the category with the given id, or null if it doesn't exist
     */
    @Processor
    public Category getCategory(final String id) {
        return getClientProvider().getClient(Category.class).getById(id);
    }

    /**
     * Get a {@link org.mule.modules.handshake.core.CustomerGroup}, given its id
     * 
     * @param id of the CustomerGroup to get. The id is the one specified on creation, and not Handshake's uid
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-customer-group}
     *
     * @return the customer group with the given id, or null if it doesn't exist
     */
    @Processor
    public CustomerGroup getCustomerGroup(final String id) {
        return getClientProvider().getClient(CustomerGroup.class).getById(id);
    }

    /**
     * Get a {@link org.mule.modules.handshake.core.UserGroup}, given its id
     * 
     * @param id of the UserGroup to get. The id is the one specified on creation, and not Handshake's uid
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-user-group}
     *
     * @return the user group with the given id, or null if it doesn't exist
     */
    @Processor
    public UserGroup getUserGroup(final String id) {
        return getClientProvider().getClient(UserGroup.class).getById(id);
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
        return getClientProvider().getClient(Order.class).create(order);
    }

    /**
     * Get a {@link org.mule.modules.handshake.core.Address}, given its id
     * 
     * @param resourceUri of the Address to get. The uri is Handshake's uid, as returned by the creation method (like '/api/v2/&lt;resource&gt;/&lt;id&gt;')
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:get-address}
     *
     * @return the address with the given id or a {@link HandshakeAPIException}, if the Address doesn't exist
     */
    @Processor
    public Address getAddress(final String resourceUri) {
        return getClientProvider().getClient(Address.class).getByResourceUri(resourceUri);
    }

    /**
     * Creates a {@link org.mule.modules.handshake.core.Address} on Handshake
     * 
     * @param address to create
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:create-address}
     *
     * @return the created address
     */
    @Processor
    public Address createAddress(final Address address) {
        return getClientProvider().getClient(Address.class).create(address);
    }

    /**
     * Updates a {@link org.mule.modules.handshake.core.Address} on Handshake, given its resourceUri
     * 
     * @param resourceUri of the Address to edit (if you skip this, you should include the resourceUri attribute in the address)
     * @param address with the changes to update. You should only include those fields that you want to update, specially if referencing existing nested objects
     *
     * {@sample.xml ../../../doc/mule-module-handshake.xml.sample handshake:update-address}
     *
     * @return the updated address
     */
    @Processor
    public Address updateAddress(@Optional final String resourceUri, final Address address) {
        return getClientProvider().getClient(Address.class).update(resourceUri, address);
    }

    public HandshakeClientProvider getClientProvider() {
        if (clientProvider == null) {
            clientProvider = new HandshakeClientProviderImpl(apiKey, securityToken);
        }
        return clientProvider;
    }
}
