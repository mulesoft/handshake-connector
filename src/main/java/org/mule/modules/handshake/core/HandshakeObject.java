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

public abstract class HandshakeObject {
    private Date mtime;
    private Date ctime;
    private String owner;
    private String ownerName;
    private String objID;

    public Date getMtime() {
        return mtime;
    }
    public Date getCtime() {
        return ctime;
    }
	public String getOwner() {
		return owner;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public String getObjID() {
		return objID;
	}
	public void setObjID(final String objID) {
		this.objID = objID;
	}
    // FIXME: This could be implemented here, but the samples wouldn't parse it: http://www.mulesoft.org/jira/browse/DEVKIT-317
    public abstract String getResourceUri();
}
