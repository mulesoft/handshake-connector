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

import org.mule.modules.handshake.core.Customer;

public interface CustomersClient {

    /**
     * Get all customers for a given account
     */
    List<Customer> getCustomers();

    /**
     * Get a customer by id
     * @param id of the Customer to get
     * @return a Customer, or null
     */
    Customer getCustomer(String id);
}
