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
 * Representation of an Item's Variant resource in Handshake
 * http://www.handshake-app.com/help/kb/api/variant-resource
 * 
 * @author marianosimone
 */
public class Variant extends HandshakeObject {
    @SerializedName("resource_uri")
    private String resourceUri;

    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }
    public String getResourceUri() {
        return this.resourceUri;
    }
}
