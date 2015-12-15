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
