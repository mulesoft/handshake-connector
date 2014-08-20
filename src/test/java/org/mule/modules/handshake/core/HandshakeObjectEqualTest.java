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
