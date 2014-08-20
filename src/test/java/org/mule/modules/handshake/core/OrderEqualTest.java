/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
