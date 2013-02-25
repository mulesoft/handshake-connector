/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

public class InvalidHandshakeObjectReferenceException extends HandshakeAPIException {

    private static final long serialVersionUID = -1346639624265450671L;

    public InvalidHandshakeObjectReferenceException(final String message) {
        super(message);
    }

    public InvalidHandshakeObjectReferenceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidHandshakeObjectReferenceException(final Throwable cause) {
        super(cause);
    }

}
