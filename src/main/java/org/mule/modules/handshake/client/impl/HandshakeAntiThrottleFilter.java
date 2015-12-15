/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.client.impl;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class HandshakeAntiThrottleFilter extends ClientFilter {

    private static String ANTI_THROTTLE_HEADER_NAME = "X-throttle-secret";
    private final String antiThrottleKey;
    
    public HandshakeAntiThrottleFilter(final String antiThrottleKey) {
        this.antiThrottleKey = antiThrottleKey;
    }

    @Override
    public ClientResponse handle(final ClientRequest cr) throws ClientHandlerException {
        if (!cr.getHeaders().containsKey(ANTI_THROTTLE_HEADER_NAME)) {
            cr.getHeaders().add(ANTI_THROTTLE_HEADER_NAME, this.antiThrottleKey);
        }
        return getNext().handle(cr);
    }

}
