/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.core;

import java.util.Date;

public class HandshakeObject {
    private Date mtime;
    private Date ctime;

    public Date getMtime() {
        return mtime;
    }
    public Date getCtime() {
        return ctime;
    }
}