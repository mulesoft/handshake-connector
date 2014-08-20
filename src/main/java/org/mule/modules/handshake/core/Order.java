/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.handshake.core;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Sales Order resource in Handshake
 * http://www.handshake-app.com/help/kb/api/order-resource
 * 
 * @author marianosimone
 * @author adrianhsieh
 */
public class Order extends HandshakeObject {
    private String id;
    private Customer customer;
    private Address billTo;
    private Address shipTo;
    private CreditCard creditCard;
    private String userGroup;
    private String category;
    private List<SalesOrderLine> lines;
    private Date lastEdited;
    private String manufacturerIds;
    private String manufacturerNames;
    private String status;
    private String shippingMethod;
    private String paymentTerms;
    private String notes;
    private String customerPO;
    private boolean emailSent;
    private String startShipDate;
    private String cancelDate;
    private boolean freeShipping;
    private boolean shipPartial;
    private String signatureURL;
    private List<String> photoURLs;
    @SerializedName("resource_uri")
    private String resourceUri;
    private String totalOffDiscount;
    private String percentDiscount;
    
    
    public String getTotalOffDiscount() {
		return totalOffDiscount;
	}
	public void setTotalOffDiscount(String totalOffDiscount) {
		this.totalOffDiscount = totalOffDiscount;
	}
	public String getPercentDiscount() {
		return percentDiscount;
	}
	public void setPercentDiscount(String percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

    public String getId() {
        return id;
    }
    public void setId(final String id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }
    public Address getBillTo() {
        return billTo;
    }
    public void setBillTo(final Address billTo) {
        this.billTo = billTo;
    }
    public Address getShipTo() {
        return shipTo;
    }
    public void setShipTo(final Address shipTo) {
        this.shipTo = shipTo;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(final CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    public String getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(final String userGroup) {
        this.userGroup = userGroup;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(final String category) {
        this.category = category;
    }
    public List<SalesOrderLine> getLines() {
        return lines;
    }
    public void setLines(final List<SalesOrderLine> lines) {
        this.lines = lines;
    }
    public Date getLastEdited() {
        return lastEdited;
    }
    public void setLastEdited(final Date lastEdited) {
        this.lastEdited = lastEdited;
    }
    public String getManufacturerIds() {
        return manufacturerIds;
    }
    public void setManufacturerIds(final String manufacturerIds) {
        this.manufacturerIds = manufacturerIds;
    }
    public String getManufacturerNames() {
        return manufacturerNames;
    }
    public void setManufacturerNames(final String manufacturerNames) {
        this.manufacturerNames = manufacturerNames;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(final String status) {
        this.status = status;
    }
    public String getShippingMethod() {
        return shippingMethod;
    }
    public void setShippingMethod(final String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
    public String getPaymentTerms() {
        return paymentTerms;
    }
    public void setPaymentTerms(final String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(final String notes) {
        this.notes = notes;
    }
    public String getCustomerPO() {
        return customerPO;
    }
    public void setCustomerPO(final String customerPO) {
        this.customerPO = customerPO;
    }
    public boolean isEmailSent() {
        return emailSent;
    }
    public void setEmailSent(final boolean emailSent) {
        this.emailSent = emailSent;
    }
    public String getStartShipDate() {
        return startShipDate;
    }
    public void setStartShipDate(final String startShipDate) {
        this.startShipDate = startShipDate;
    }
    public String getCancelDate() {
        return cancelDate;
    }
    public void setCancelDate(final String cancelDate) {
        this.cancelDate = cancelDate;
    }
    public boolean isFreeShipping() {
        return freeShipping;
    }
    public void setFreeShipping(final boolean freeShipping) {
        this.freeShipping = freeShipping;
    }
    public boolean isShipPartial() {
        return shipPartial;
    }
    public void setShipPartial(final boolean shipPartial) {
        this.shipPartial = shipPartial;
    }
    public String getSignatureURL() {
        return signatureURL;
    }
    public void setSignatureURL(final String signatureURL) {
        this.signatureURL = signatureURL;
    }
    public List<String> getPhotoURLs() {
        return photoURLs;
    }
    public void setPhotoURLs(final List<String> photoURLs) {
        this.photoURLs = photoURLs;
    }
    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }
    @Override
    public String getResourceUri() {
        return this.resourceUri;
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billTo == null) ? 0 : billTo.hashCode());
		result = prime * result + ((cancelDate == null) ? 0 : cancelDate.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((creditCard == null) ? 0 : creditCard.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((customerPO == null) ? 0 : customerPO.hashCode());
		result = prime * result + (emailSent ? 1231 : 1237);
		result = prime * result + (freeShipping ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastEdited == null) ? 0 : lastEdited.hashCode());
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result + ((manufacturerIds == null) ? 0 : manufacturerIds.hashCode());
		result = prime * result + ((manufacturerNames == null) ? 0 : manufacturerNames.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((paymentTerms == null) ? 0 : paymentTerms.hashCode());
		result = prime * result + ((percentDiscount == null) ? 0 : percentDiscount.hashCode());
		result = prime * result + ((photoURLs == null) ? 0 : photoURLs.hashCode());
		result = prime * result + ((resourceUri == null) ? 0 : resourceUri.hashCode());
		result = prime * result + (shipPartial ? 1231 : 1237);
		result = prime * result + ((shipTo == null) ? 0 : shipTo.hashCode());
		result = prime * result + ((shippingMethod == null) ? 0 : shippingMethod.hashCode());
		result = prime * result + ((signatureURL == null) ? 0 : signatureURL.hashCode());
		result = prime * result + ((startShipDate == null) ? 0 : startShipDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((totalOffDiscount == null) ? 0 : totalOffDiscount.hashCode());
		result = prime * result + ((userGroup == null) ? 0 : userGroup.hashCode());
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
		Order other = (Order) obj;
		if (billTo == null) {
			if (other.billTo != null)
				return false;
		} else if (!billTo.equals(other.billTo))
			return false;
		if (cancelDate == null) {
			if (other.cancelDate != null)
				return false;
		} else if (!cancelDate.equals(other.cancelDate))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creditCard == null) {
			if (other.creditCard != null)
				return false;
		} else if (!creditCard.equals(other.creditCard))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (customerPO == null) {
			if (other.customerPO != null)
				return false;
		} else if (!customerPO.equals(other.customerPO))
			return false;
		if (emailSent != other.emailSent)
			return false;
		if (freeShipping != other.freeShipping)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastEdited == null) {
			if (other.lastEdited != null)
				return false;
		} else if (!lastEdited.equals(other.lastEdited))
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (manufacturerIds == null) {
			if (other.manufacturerIds != null)
				return false;
		} else if (!manufacturerIds.equals(other.manufacturerIds))
			return false;
		if (manufacturerNames == null) {
			if (other.manufacturerNames != null)
				return false;
		} else if (!manufacturerNames.equals(other.manufacturerNames))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (paymentTerms == null) {
			if (other.paymentTerms != null)
				return false;
		} else if (!paymentTerms.equals(other.paymentTerms))
			return false;
		if (percentDiscount == null) {
			if (other.percentDiscount != null)
				return false;
		} else if (!percentDiscount.equals(other.percentDiscount))
			return false;
		if (photoURLs == null) {
			if (other.photoURLs != null)
				return false;
		} else if (!photoURLs.equals(other.photoURLs))
			return false;
		if (resourceUri == null) {
			if (other.resourceUri != null)
				return false;
		} else if (!resourceUri.equals(other.resourceUri))
			return false;
		if (shipPartial != other.shipPartial)
			return false;
		if (shipTo == null) {
			if (other.shipTo != null)
				return false;
		} else if (!shipTo.equals(other.shipTo))
			return false;
		if (shippingMethod == null) {
			if (other.shippingMethod != null)
				return false;
		} else if (!shippingMethod.equals(other.shippingMethod))
			return false;
		if (signatureURL == null) {
			if (other.signatureURL != null)
				return false;
		} else if (!signatureURL.equals(other.signatureURL))
			return false;
		if (startShipDate == null) {
			if (other.startShipDate != null)
				return false;
		} else if (!startShipDate.equals(other.startShipDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalOffDiscount == null) {
			if (other.totalOffDiscount != null)
				return false;
		} else if (!totalOffDiscount.equals(other.totalOffDiscount))
			return false;
		if (userGroup == null) {
			if (other.userGroup != null)
				return false;
		} else if (!userGroup.equals(other.userGroup))
			return false;
		return true;
	}
    
    
}
