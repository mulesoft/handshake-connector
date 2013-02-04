package org.mule.modules.handshake.client;

import java.util.List;

import org.mule.modules.handshake.core.Customer;

public interface CustomersClient {
    List<Customer> getCustomers();
}
