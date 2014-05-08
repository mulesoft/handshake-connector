/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.core;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Customer Group resource in Handshake
 * http://www.handshake-app.com/help/kb/api/customer-group-resource
 * 
 * @author marianosimone
 */
public class CustomerGroup extends HandshakeObject {
    private String name;
    private String id;
    private String currency;
    @SerializedName("resource_uri")
    private String resourceUri;

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(final String id) {
        this.id = id;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }
    @Override
    public String getResourceUri() {
        return this.resourceUri;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((resourceUri == null) ? 0 : resourceUri.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerGroup other = (CustomerGroup) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (resourceUri == null) {
			if (other.resourceUri != null)
				return false;
		} else if (!resourceUri.equals(other.resourceUri))
			return false;
		return true;
	}
    
    
}
