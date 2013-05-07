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
 * Representation of an Address resource in Handshake
 * http://www.handshake-app.com/help/kb/api/address-resource
 * 
 * @author marianosimone
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
}
