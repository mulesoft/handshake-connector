/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
