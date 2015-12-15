/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.client.impl;

public class HandshakeAPIException extends RuntimeException {

    private static final long serialVersionUID = 7686116903373295386L;

    public HandshakeAPIException(final String message) {
        super(message);
    }

    public HandshakeAPIException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public HandshakeAPIException(final Throwable cause) {
        super(cause);
    }
}
