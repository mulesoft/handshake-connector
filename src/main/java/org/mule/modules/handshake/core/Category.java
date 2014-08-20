/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.handshake.core;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Category resource in Handshake
 * http://www.handshake-app.com/help/kb/api/category-resource
 * 
 * @author marianosimone
 */
public class Category extends HandshakeObject {
    private String name;
    private String id;
    private Integer categoryPosition;
    private String parent;
    private CategorySubType subType;
    private List<String> subcategories;
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
    public Integer getCategoryPosition() {
        return categoryPosition;
    }
    public void setCategoryPosition(final Integer categoryPosition) {
        this.categoryPosition = categoryPosition;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(final String parent) {
        this.parent = parent;
    }
    public CategorySubType getSubType() {
        return subType;
    }
    public void setSubType(final CategorySubType subType) {
        this.subType = subType;
    }
    public List<String> getSubcategories() {
        return subcategories;
    }
    public void setSubcategories(final List<String> subcategories) {
        this.subcategories = subcategories;
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
		result = prime * result + ((categoryPosition == null) ? 0 : categoryPosition.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((resourceUri == null) ? 0 : resourceUri.hashCode());
		result = prime * result + ((subType == null) ? 0 : subType.hashCode());
		result = prime * result + ((subcategories == null) ? 0 : subcategories.hashCode());
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
		Category other = (Category) obj;
		if (categoryPosition == null) {
			if (other.categoryPosition != null)
				return false;
		} else if (!categoryPosition.equals(other.categoryPosition))
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
		if (subType != other.subType)
			return false;
		if (subcategories == null) {
			if (other.subcategories != null)
				return false;
		} else if (!subcategories.equals(other.subcategories))
			return false;
		return true;
	}
    
    
}
