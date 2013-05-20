/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class HandshakeAntiThrottleFilter extends ClientFilter {

    private static String ANTI_THROTTLE_HEADER_NAME = "HTTP_X_THROTTLE_SECRET";
    private static String ANTI_THROTTLE_KEY = "eu6qQ2v2vUjNwLPG95JOQEkF82bsZvk6zjEYGpuXJREULh00D3nKexYjxjJcC10g";

    @Override
    public ClientResponse handle(final ClientRequest cr) throws ClientHandlerException {
        if (!cr.getHeaders().containsKey(ANTI_THROTTLE_HEADER_NAME)) {
            cr.getHeaders().add(ANTI_THROTTLE_HEADER_NAME, ANTI_THROTTLE_KEY);
        }
        return getNext().handle(cr);
    }

}
