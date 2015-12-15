/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.core;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a User Group resource in Handshake
 * http://www.handshake-app.com/help/kb/api/user-group-resource
 */
public class UserGroup extends HandshakeObject {
    private String name;
    private String id;
    private boolean isMaster;
    private String parent;
    private List<String> categories;
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
    public void setId(String id) {
        this.id = id;
    }
    public boolean isMaster() {
        return isMaster;
    }
    public void setMaster(final boolean isMaster) {
        this.isMaster = isMaster;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(final String parent) {
        this.parent = parent;
    }
    public List<String> getCategories() {
        return categories;
    }
    public void setCategories(final List<String> categories) {
        this.categories = categories;
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
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isMaster ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
		UserGroup other = (UserGroup) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isMaster != other.isMaster)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (resourceUri == null) {
			if (other.resourceUri != null)
				return false;
		} else if (!resourceUri.equals(other.resourceUri))
			return false;
		return true;
	}
    
}
