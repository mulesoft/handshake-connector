/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.handshake;

import org.junit.Before;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.handshake.client.impl.InvalidHandshakeObjectReferenceException;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.HandshakeConnector;

public class HandshakeConnectorTest {

    private HandshakeConnector connector;

    @Before
    public void connect() throws ConnectionException {
        connector = new HandshakeConnector();
        connector.setEndpoint("http://someendpoint.com");
        connector.connect("SOME_KEY", "SOME_TOKEN");
    }

    @Test(expected=InvalidHandshakeObjectReferenceException.class)
    public void getOrderWithBadUriShouldRaise() {
        connector.getOrder("/blah/568");
    }

    @Test(expected=InvalidHandshakeObjectReferenceException.class)
    public void updatingACustomerWithoutResourceUriShouldFail() {
        connector.updateCustomer(null, new Customer());
    }
}
