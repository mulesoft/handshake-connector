/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client;

import org.mule.modules.handshake.core.Category;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.CustomerGroup;
import org.mule.modules.handshake.core.Item;
import org.mule.modules.handshake.core.Order;

/**
 * Facade to group all Handshake clients
 * 
 * @author marianosimone
 *
 */
public interface HandshakeClientProvider {
    GenericHandshakeClient<Customer> getCustomersClient();
    GenericHandshakeClient<Item> getItemsClient();
    GenericHandshakeClient<Order> getOrdersClient();
    GenericHandshakeClient<Category> getCategoriesClient();
    GenericHandshakeClient<CustomerGroup> getCustomerGroupsClient();
}
