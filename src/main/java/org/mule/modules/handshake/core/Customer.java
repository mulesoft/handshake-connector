/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
}
