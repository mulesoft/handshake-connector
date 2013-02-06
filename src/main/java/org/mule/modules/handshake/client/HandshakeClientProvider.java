/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client;

/**
 * Facade to group all Handshake clients
 * 
 * @author marianosimone
 *
 */
public interface HandshakeClientProvider {
    CustomersClient getCustomersClient();
    ItemsClient getItemsClient();
    OrdersClient getOrdersClient();
}
