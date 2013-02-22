/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.core;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of an Item's Variant resource in Handshake
 * http://www.handshake-app.com/help/kb/api/variant-resource
 * 
 * @author marianosimone
 */
public class Variant extends HandshakeObject {

    private String sku;
    private BigDecimal unitPrice;
    private String barcode;
    @SerializedName("resource_uri")
    private String resourceUri;

    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }
    public String getResourceUri() {
        return this.resourceUri;
    }
}
