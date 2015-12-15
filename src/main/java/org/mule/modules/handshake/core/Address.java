/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.core;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of an Address resource in Handshake
 * http://www.handshake-app.com/help/kb/api/address-resource
 */
public class Address extends HandshakeObject {
    private String id;
    private String name;
    private String street;
    private String street2;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String phone;
    private String fax;
    private Boolean isDefaultShipTo;
    private String multiLineStr;
    private String stCustomer;
    @SerializedName("resource_uri")
    private String resourceUri;

    public Boolean getIsDefaultShipTo() {
    	return isDefaultShipTo;
    }
    
    public void setIsDefaultShipTo(final Boolean isDefaultShipTo) {
    	this.isDefaultShipTo = isDefaultShipTo;
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
    public String getStreet() {
        return street;
    }
    public void setStreet(final String street) {
        this.street = street;
    }
    public String getStreet2() {
        return street2;
    }
    public void setStreet2(final String street2) {
        this.street2 = street2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(final String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(final String state) {
        this.state = state;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(final String country) {
        this.country = country;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(final String fax) {
        this.fax = fax;
    }
    public String getMultiLineStr() {
        return multiLineStr;
    }
    public void setMultiLineStr(final String multiLineStr) {
        this.multiLineStr = multiLineStr;
    }
    public String getStCustomer() {
        return stCustomer;
    }
    public void setStCustomer(final String stCustomer) {
        this.stCustomer = stCustomer;
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDefaultShipTo == null) ? 0 : isDefaultShipTo.hashCode());
		result = prime * result + ((multiLineStr == null) ? 0 : multiLineStr.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((resourceUri == null) ? 0 : resourceUri.hashCode());
		result = prime * result + ((stCustomer == null) ? 0 : stCustomer.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((street2 == null) ? 0 : street2.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDefaultShipTo == null) {
			if (other.isDefaultShipTo != null)
				return false;
		} else if (!isDefaultShipTo.equals(other.isDefaultShipTo))
			return false;
		if (multiLineStr == null) {
			if (other.multiLineStr != null)
				return false;
		} else if (!multiLineStr.equals(other.multiLineStr))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (resourceUri == null) {
			if (other.resourceUri != null)
				return false;
		} else if (!resourceUri.equals(other.resourceUri))
			return false;
		if (stCustomer == null) {
			if (other.stCustomer != null)
				return false;
		} else if (!stCustomer.equals(other.stCustomer))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (street2 == null) {
			if (other.street2 != null)
				return false;
		} else if (!street2.equals(other.street2))
			return false;
		return true;
	}
    
    
}
