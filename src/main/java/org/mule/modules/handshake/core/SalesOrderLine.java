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

/**
 * Representation of a Sales Order Line resource in Handshake
 * http://www.handshake-app.com/help/kb/api/salesorderline-objects
 * 
 * @author marianosimone
 */
public class SalesOrderLine extends HandshakeObject {

    private String isku;
    private String vsku;
    private String sku;
    private String barcode;
    private String item;
    private String description;
    private Integer qty;
    private BigDecimal unitPrice = BigDecimal.ZERO;
    private String notes;
    private String listPrice;
    private String discount;
    private String percentageDiscount;

    public String getIsku() {
        return isku;
    }
    public void setIsku(final String isku) {
        this.isku = isku;
    }
    public String getVsku() {
        return vsku;
    }
    public void setVsku(final String vsku) {
        this.vsku = vsku;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(final String sku) {
        this.sku = sku;
    }
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }
    public String getItem() {
        return item;
    }
    public void setItem(final String item) {
        this.item = item;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(final String description) {
        this.description = description;
    }
    public Integer getQty() {
        return qty;
    }
    public void setQty(final Integer qty) {
        this.qty = qty;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(final BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(final String notes) {
        this.notes = notes;
    }
    public String getListPrice() {
        return listPrice;
    }
    public void setListPrice(final String listPrice) {
        this.listPrice = listPrice;
    }
    public String getDiscount() {
        return discount;
    }
    public void setDiscount(final String discount) {
        this.discount = discount;
    }
    public String getPercentageDiscount() {
        return percentageDiscount;
    }
    public void setPercentageDiscount(final String percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }
    @Override
    public String getResourceUri() {
        return null;
    }
}
