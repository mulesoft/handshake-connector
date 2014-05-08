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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((isku == null) ? 0 : isku.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((listPrice == null) ? 0 : listPrice.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((percentageDiscount == null) ? 0 : percentageDiscount.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		result = prime * result + ((vsku == null) ? 0 : vsku.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrderLine other = (SalesOrderLine) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (isku == null) {
			if (other.isku != null)
				return false;
		} else if (!isku.equals(other.isku))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (listPrice == null) {
			if (other.listPrice != null)
				return false;
		} else if (!listPrice.equals(other.listPrice))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (percentageDiscount == null) {
			if (other.percentageDiscount != null)
				return false;
		} else if (!percentageDiscount.equals(other.percentageDiscount))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		if (vsku == null) {
			if (other.vsku != null)
				return false;
		} else if (!vsku.equals(other.vsku))
			return false;
		return true;
	}
    
    
}
