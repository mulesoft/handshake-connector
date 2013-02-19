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
    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }
    public String getResourceUri() {
        return this.resourceUri;
    }
}
