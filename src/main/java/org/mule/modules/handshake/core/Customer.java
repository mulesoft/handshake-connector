/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.handshake.core;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Customer resource in Handshake
 * http://www.handshake-app.com/help/kb/api/customer-resource
 * 
 * @author marianosimone
 */
public class Customer extends HandshakeObject {
    private String contact;
    private String id;
    private String name;
    private String email;
    private String taxId;
    private Address billTo;
    private List<Address> shipTos;
    private String defaultShipTo;
    private List<CreditCard> creditCards;
    private UserGroup userGroup;
    private CustomerGroup customerGroup;
    private String shippingMethod;
    private String paymentTerms;
    private String currency;
    private String locale;
    @SerializedName("resource_uri")
    private String resourceUri;

    public String getContact() {
        return contact;
    }
    public void setContact(final String contact) {
        this.contact = contact;
    }
    public String getId() {
        return id;
    }
    public void setId(final String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(final String email) {
        this.email = email;
    }
    public String getTaxId() {
        return taxId;
    }
    public void setTaxId(final String taxId) {
        this.taxId = taxId;
    }
    public Address getBillTo() {
        return billTo;
    }
    public void setBillTo(final Address billTo) {
        this.billTo = billTo;
    }
    public List<Address> getShipTos() {
        return shipTos;
    }
    public void setShipTos(final List<Address> shipTos) {
        this.shipTos = shipTos;
    }
    public String getDefaultShipTo() {
        return defaultShipTo;
    }
    public void setDefaultShipTo(final String defaultShipTo) {
        this.defaultShipTo = defaultShipTo;
    }
    public List<CreditCard> getCreditCards() {
        return creditCards;
    }
    public void setCreditCards(final List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    public UserGroup getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(final UserGroup userGroup) {
        this.userGroup = userGroup;
    }
    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }
    public void setCustomerGroup(final CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
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
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    public String getLocale() {
        return locale;
    }
    public void setLocale(final String locale) {
        this.locale = locale;
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
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((creditCards == null) ? 0 : creditCards.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((customerGroup == null) ? 0 : customerGroup.hashCode());
		result = prime * result + ((defaultShipTo == null) ? 0 : defaultShipTo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((paymentTerms == null) ? 0 : paymentTerms.hashCode());
		result = prime * result + ((resourceUri == null) ? 0 : resourceUri.hashCode());
		result = prime * result + ((shipTos == null) ? 0 : shipTos.hashCode());
		result = prime * result + ((shippingMethod == null) ? 0 : shippingMethod.hashCode());
		result = prime * result + ((taxId == null) ? 0 : taxId.hashCode());
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
		Customer other = (Customer) obj;
		if (billTo == null) {
			if (other.billTo != null)
				return false;
		} else if (!billTo.equals(other.billTo))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (creditCards == null) {
			if (other.creditCards != null)
				return false;
		} else if (!creditCards.equals(other.creditCards))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (customerGroup == null) {
			if (other.customerGroup != null)
				return false;
		} else if (!customerGroup.equals(other.customerGroup))
			return false;
		if (defaultShipTo == null) {
			if (other.defaultShipTo != null)
				return false;
		} else if (!defaultShipTo.equals(other.defaultShipTo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (paymentTerms == null) {
			if (other.paymentTerms != null)
				return false;
		} else if (!paymentTerms.equals(other.paymentTerms))
			return false;
		if (resourceUri == null) {
			if (other.resourceUri != null)
				return false;
		} else if (!resourceUri.equals(other.resourceUri))
			return false;
		if (shipTos == null) {
			if (other.shipTos != null)
				return false;
		} else if (!shipTos.equals(other.shipTos))
			return false;
		if (shippingMethod == null) {
			if (other.shippingMethod != null)
				return false;
		} else if (!shippingMethod.equals(other.shippingMethod))
			return false;
		if (taxId == null) {
			if (other.taxId != null)
				return false;
		} else if (!taxId.equals(other.taxId))
			return false;
		if (userGroup == null) {
			if (other.userGroup != null)
				return false;
		} else if (!userGroup.equals(other.userGroup))
			return false;
		return true;
	}
    
    
}
