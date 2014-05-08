/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.core;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class CustomerEqualTest {

	@Test
	public void testCustomersAreEqual() {
		
		Customer customer = createCustomerWithResourceURIAndName("api/customers/123","Carlos Saul");
		Customer someCustomer = createCustomerWithResourceURIAndName("api/customers/123","Carlos Saul");
		
		assertEquals(customer,someCustomer);
		
	}
	
	@Test
	public void testCustomersAreNotEqual() {
		
		Customer customerA = createCustomerWithResourceURIAndName("api/customers/123A","Carlos Saul");
		Customer customerB = createCustomerWithResourceURIAndName("api/customers/123B","Domingo");
		
		assertFalse(customerA.equals(customerB));
		
	}
	
	
	private Customer createCustomerWithResourceURIAndName (String resourceUri, String name) {

		Customer customer = new Customer();
		customer.setResourceUri(resourceUri);
		customer.setName(name);
		
		return customer;
		
	}
	
	
}
