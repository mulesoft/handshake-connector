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
 * Representation of a Credit Card resource in Handshake
 * http://www.handshake-app.com/help/kb/api/credit-card-resource
 * 
 * @author marianosimone
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
    public void setType(String type) {
        this.type = type;
    }
    public String getLastFour() {
        return lastFour;
    }
    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getExpiry() {
        return expiry;
    }
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }
    public String getResourceUri() {
        return this.resourceUri;
    }
}
