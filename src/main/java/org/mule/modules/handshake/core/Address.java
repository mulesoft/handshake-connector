package org.mule.modules.handshake.core;

/**
 * Representation of an Address resource in Handshake
 * http://www.handshake-app.com/help/kb/api/address-resource
 * 
 * @author marianosimone
 */
public class Address {
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
    private String multiLineStr;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreet2() {
        return street2;
    }
    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getMultiLineStr() {
        return multiLineStr;
    }
    public void setMultiLineStr(String multiLineStr) {
        this.multiLineStr = multiLineStr;
    }
}