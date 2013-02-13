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

/**
 * Representation of a Category resource in Handshake
 * http://www.handshake-app.com/help/kb/api/category-resource
 * 
 * @author marianosimone
 */
public class Category {
    private String name;
    private String id;
    private int categoryPosition;
    private String parent;
    private List<String> subcategories;

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
    public List<String> getSubcategories() {
        return subcategories;
    }
    public void setSubcategories(List<String> subcategories) {
        this.subcategories = subcategories;
    }
}
