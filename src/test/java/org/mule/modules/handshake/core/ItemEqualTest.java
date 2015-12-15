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

public class ItemEqualTest {

	@Test
	public void testItemsAreEqual() {
		
		Item item = createItemWithSkuAndResourceUri("Sku","api/items/123");
		Item someItem = createItemWithSkuAndResourceUri("Sku","api/items/123");
		
		assertEquals(item,someItem);
		
	}
	
	@Test
	public void testItemsAreNotEqual() {
		
		Item itemA = createItemWithSkuAndResourceUri("SkuA","api/items/123A");
		Item itemB = createItemWithSkuAndResourceUri("SkuB","api/items/123B");
		
		assertFalse(itemA.equals(itemB));
		
	}

	
	private Item createItemWithSkuAndResourceUri (String sku, String resourceUri) {
		
		Item item = new Item();
		item.setSku(sku);
		item.setResourceUri(resourceUri);
		
		return item;
		
	}
	
	
}
