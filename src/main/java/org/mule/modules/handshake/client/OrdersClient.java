/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client;

import java.util.List;
import java.util.Map;

import org.mule.modules.handshake.core.Order;

/**
 * Client for the Order resource: http://www.handshake-app.com/help/kb/api/order-resource
 * @author marianosimone
 *
 */
public interface OrdersClient {

	/**
	 * Get the orders
	 * @return all the Orders
	 */
	List<Order> getOrders();

	/**
     * Get the orders
     * @return all the Orders matching the given filter
     */
    List<Order> getOrders(Map<String, String> filters);
}
