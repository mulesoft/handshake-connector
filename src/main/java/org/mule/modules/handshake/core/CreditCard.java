/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.core;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Credit Card resource in Handshake
 * http://www.handshake-app.com/help/kb/api/credit-card-resource
 */
public class CreditCard extends HandshakeObject {
    private String type;
    private String lastFour;
    private String month;
    private String year;
    private String expiry;
    private String name;
    private String number;
    private String cvv;
    @SerializedName("resource_uri")
    private String resourceUri;

    public String getType() {
        return type;
    }
    public void setType(final String type) {
        this.type = type;
    }
    public String getLastFour() {
        return lastFour;
    }
    public void setLastFour(final String lastFour) {
        this.lastFour = lastFour;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(final String month) {
        this.month = month;
    }
    public String getYear() {
        return year;
    }
    public void setYear(final String year) {
        this.year = year;
    }
    public String getExpiry() {
        return expiry;
    }
    public void setExpiry(final String expiry) {
        this.expiry = expiry;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(final String number) {
        this.number = number;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(final String cvv) {
        this.cvv = cvv;
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
		result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
		result = prime * result + ((expiry == null) ? 0 : expiry.hashCode());
		result = prime * result + ((lastFour == null) ? 0 : lastFour.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((resourceUri == null) ? 0 : resourceUri.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		CreditCard other = (CreditCard) obj;
		if (cvv == null) {
			if (other.cvv != null)
				return false;
		} else if (!cvv.equals(other.cvv))
			return false;
		if (expiry == null) {
			if (other.expiry != null)
				return false;
		} else if (!expiry.equals(other.expiry))
			return false;
		if (lastFour == null) {
			if (other.lastFour != null)
				return false;
		} else if (!lastFour.equals(other.lastFour))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (resourceUri == null) {
			if (other.resourceUri != null)
				return false;
		} else if (!resourceUri.equals(other.resourceUri))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
    
    
}
