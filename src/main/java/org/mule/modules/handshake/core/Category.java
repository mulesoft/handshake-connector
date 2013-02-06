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
    private Category parent;
    private List<Category> subcategories;

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
    public Category getParent() {
        return parent;
    }
    public void setParent(Category parent) {
        this.parent = parent;
    }
    public List<Category> getSubcategories() {
        return subcategories;
    }
    public void setSubcategories(List<Category> subcategories) {
        this.subcategories = subcategories;
    }
}
