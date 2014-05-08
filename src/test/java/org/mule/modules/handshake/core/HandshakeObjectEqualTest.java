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

public class HandshakeObjectEqualTest {

	@Test
	public void testHandshakeObjectsAreEqual() {
		
		SomeHandhakeObject SomeHandhakeObjectA = createSomeHandshakeObjectSomeStringAttribute("ObjIDA");
		SomeHandhakeObject SomeHandhakeObjectB = createSomeHandshakeObjectSomeStringAttribute("ObjIDA");
		
		assertTrue(SomeHandhakeObjectA.equals(SomeHandhakeObjectB));
		
	}
	
	@Test
	public void testHandshakeObjectsAreNotEqual() {
		
		SomeHandhakeObject SomeHandhakeObjectA = createSomeHandshakeObjectSomeStringAttribute("ObjIDA");
		SomeHandhakeObject SomeHandhakeObjectB = createSomeHandshakeObjectSomeStringAttribute("ObjIDB");
		
		assertFalse(SomeHandhakeObjectA.equals(SomeHandhakeObjectB));
		
	}
	
	private SomeHandhakeObject createSomeHandshakeObjectSomeStringAttribute (String someObjID) {
		
		SomeHandhakeObject someHandshakeObject = new SomeHandhakeObject();
		
		someHandshakeObject.setObjID(someObjID);
				
		return someHandshakeObject;
		
	}
	
	private class SomeHandhakeObject extends HandshakeObject {

		@Override
		public String getResourceUri() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
