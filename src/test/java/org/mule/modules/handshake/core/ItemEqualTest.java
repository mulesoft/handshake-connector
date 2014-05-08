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
