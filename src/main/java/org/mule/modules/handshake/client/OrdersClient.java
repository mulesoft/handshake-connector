package org.mule.modules.handshake.client;

import java.util.List;

import org.mule.modules.handshake.core.Order;

public interface OrdersClient {

	/**
	 * Get the orders
	 * @return all the Orders matching the given filter
	 */
	List<Order> getOrders();
}
