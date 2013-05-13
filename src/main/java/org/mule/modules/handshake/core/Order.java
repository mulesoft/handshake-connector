/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
}
