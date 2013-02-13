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
 * Representation of a User Group resource in Handshake
 * http://www.handshake-app.com/help/kb/api/user-group-resource
 * 
 * @author marianosimone
 */
public class UserGroup {
    private String name;
    private String id;
    private boolean isMaster;
    private String parent;
    private List<String> categories;

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
    public boolean isMaster() {
        return isMaster;
    }
    public void setMaster(boolean isMaster) {
        this.isMaster = isMaster;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public List<String> getCategories() {
        return categories;
    }
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
