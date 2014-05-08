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

public class SalesOrderLineEqualTest {

	@Test
	public void testSalesOrderLinesAreEqual() {
		
		SalesOrderLine salesOrderLine = createSalesOrderLineWithITemAndQuantity("ItemA", 3);
		SalesOrderLine sameSalesOrderLine = createSalesOrderLineWithITemAndQuantity("ItemA", 3);
		
		assertEquals(salesOrderLine,sameSalesOrderLine);
		
	}
	
	@Test
	public void testSalesOrderLinesAreNotEqual() {
		
		SalesOrderLine salesOrderLineA = createSalesOrderLineWithITemAndQuantity("ItemA", 3);
		SalesOrderLine salesOrderLineB = createSalesOrderLineWithITemAndQuantity("ItemB", 7);
		
		assertFalse(salesOrderLineA.equals(salesOrderLineB));
		
	}

	
	private SalesOrderLine createSalesOrderLineWithITemAndQuantity (String item, Integer qty) {
		
		SalesOrderLine salesOrderLine = new SalesOrderLine();
		
		salesOrderLine.setDescription("Some fake line");
		salesOrderLine.setItem(item);
		salesOrderLine.setQty(qty);
				
		return salesOrderLine;
		
	}
	
	
}
