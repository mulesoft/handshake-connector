/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
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
