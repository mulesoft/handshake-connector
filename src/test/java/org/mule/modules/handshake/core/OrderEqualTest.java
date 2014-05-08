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

public class OrderEqualTest {

	@Test
	public void testOrdersAreEqual() {
		
		Order orderA = createOrderWithResourceURI("api/order/123");
		Order sameOrderA = createOrderWithResourceURI("api/order/123");
		
		assertEquals(orderA,sameOrderA);
		
	}
	
	@Test
	public void testOrdersAreNotEqual() {
		
		Order orderA = createOrderWithResourceURI("api/order/123");
		Order sameOrderA = createOrderWithResourceURI("api/order/456");
		
		assertFalse(orderA.equals(sameOrderA));
		
	}
	
	
	private Order createOrderWithResourceURI (String resourceURI) {
		
		Order newOrder = new Order();

		newOrder.setId("1");
		newOrder.setNotes("SomeNotes");
		newOrder.setStatus("Confirmed");
		newOrder.setResourceUri(resourceURI);
				
		return newOrder;
		
	}
	
	
}
