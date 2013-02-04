package org.mule.modules.handshake.core;

/**
 * Representation of a Customer Group resource in Handshake
 * http://www.handshake-app.com/help/kb/api/customer-group-resource
 * 
 * @author marianosimone
 */
public class CustomerGroup {
    private String name;
    private String id;
    private String currency;

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
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
