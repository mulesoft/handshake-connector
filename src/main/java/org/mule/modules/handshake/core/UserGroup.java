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
    private UserGroup parent;
    private List<UserGroup> categories;

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
    public UserGroup getParent() {
        return parent;
    }
    public void setParent(UserGroup parent) {
        this.parent = parent;
    }
    public List<UserGroup> getCategories() {
        return categories;
    }
    public void setCategories(List<UserGroup> categories) {
        this.categories = categories;
    }
}
