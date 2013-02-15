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

public class HandshakeObject {

    @SerializedName("resource_uri")
    private String resourceUri;

    public String getResourceUri() {
        return resourceUri;
    }
    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }
}
