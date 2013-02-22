/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
    private int categoryPosition;
    private String parent;
    private CategorySubType subType;
    private List<String> subcategories;
    @SerializedName("resource_uri")
    private String resourceUri;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getCategoryPosition() {
        return categoryPosition;
    }
    public void setCategoryPosition(int categoryPosition) {
        this.categoryPosition = categoryPosition;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public CategorySubType getSubType() {
        return subType;
    }
    public void setSubType(CategorySubType subType) {
        this.subType = subType;
    }
    public List<String> getSubcategories() {
        return subcategories;
    }
    public void setSubcategories(List<String> subcategories) {
        this.subcategories = subcategories;
    }
    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }
    public String getResourceUri() {
        return this.resourceUri;
    }
}
