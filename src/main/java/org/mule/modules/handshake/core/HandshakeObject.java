/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
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
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
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
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ctime == null) ? 0 : ctime.hashCode());
		result = prime * result + ((mtime == null) ? 0 : mtime.hashCode());
		result = prime * result + ((objID == null) ? 0 : objID.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HandshakeObject other = (HandshakeObject) obj;
		if (ctime == null) {
			if (other.ctime != null)
				return false;
		} else if (!ctime.equals(other.ctime))
			return false;
		if (mtime == null) {
			if (other.mtime != null)
				return false;
		} else if (!mtime.equals(other.mtime))
			return false;
		if (objID == null) {
			if (other.objID != null)
				return false;
		} else if (!objID.equals(other.objID))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		return true;
	}
    
    
}
