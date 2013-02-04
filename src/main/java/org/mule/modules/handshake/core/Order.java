package org.mule.modules.handshake.core;

import java.util.Date;
import java.util.List;

/**
 * Representation of a Sales Order resource in Handshake
 * http://www.handshake-app.com/help/kb/api/order-resource
 * 
 * @author marianosimone
 */
public class Order {
    private String id;
    private Customer customer;
    private Address billTo;
    private Address shipTo;
    private CreditCard creditCard;
    private UserGroup userGroup;
    private OrderCategory category;
    private List<SalesOrderLine> lines;
    private Date lastEdited;
    private String manufacturerIds;
    private String manufacturerNames;
    private List<String> manufacturerBreakdown;//FIXME
//    id is the manufacturer ID
//    name is the manufacturer name
//    total is the total amount of all the lines for this manufacturer
//    lines is a collection of the line items for this manufacturer
//    order.lastExported (server-only datetime)
    private String status;
    private String shippingMethod;
    private String paymentTerms;
    private double total;
    private String notes;
    private String customerPO;
    private boolean emailSent;
    private Date startShipDate;
    private Date cancelDate;
    private boolean freeShipping;
    private boolean shipPartial;
    private String signatureURL;
    private List<String> photoURLs;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Address getBillTo() {
        return billTo;
    }
    public void setBillTo(Address billTo) {
        this.billTo = billTo;
    }
    public Address getShipTo() {
        return shipTo;
    }
    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    public UserGroup getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
    public OrderCategory getCategory() {
        return category;
    }
    public void setCategory(OrderCategory category) {
        this.category = category;
    }
    public List<SalesOrderLine> getLines() {
        return lines;
    }
    public void setLines(List<SalesOrderLine> lines) {
        this.lines = lines;
    }
    public Date getLastEdited() {
        return lastEdited;
    }
    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }
    public String getManufacturerIds() {
        return manufacturerIds;
    }
    public void setManufacturerIds(String manufacturerIds) {
        this.manufacturerIds = manufacturerIds;
    }
    public String getManufacturerNames() {
        return manufacturerNames;
    }
    public void setManufacturerNames(String manufacturerNames) {
        this.manufacturerNames = manufacturerNames;
    }
    public List<String> getManufacturerBreakdown() {
        return manufacturerBreakdown;
    }
    public void setManufacturerBreakdown(List<String> manufacturerBreakdown) {
        this.manufacturerBreakdown = manufacturerBreakdown;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getShippingMethod() {
        return shippingMethod;
    }
    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
    public String getPaymentTerms() {
        return paymentTerms;
    }
    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getCustomerPO() {
        return customerPO;
    }
    public void setCustomerPO(String customerPO) {
        this.customerPO = customerPO;
    }
    public boolean isEmailSent() {
        return emailSent;
    }
    public void setEmailSent(boolean emailSent) {
        this.emailSent = emailSent;
    }
    public Date getStartShipDate() {
        return startShipDate;
    }
    public void setStartShipDate(Date startShipDate) {
        this.startShipDate = startShipDate;
    }
    public Date getCancelDate() {
        return cancelDate;
    }
    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }
    public boolean isFreeShipping() {
        return freeShipping;
    }
    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }
    public boolean isShipPartial() {
        return shipPartial;
    }
    public void setShipPartial(boolean shipPartial) {
        this.shipPartial = shipPartial;
    }
    public String getSignatureURL() {
        return signatureURL;
    }
    public void setSignatureURL(String signatureURL) {
        this.signatureURL = signatureURL;
    }
    public List<String> getPhotoURLs() {
        return photoURLs;
    }
    public void setPhotoURLs(List<String> photoURLs) {
        this.photoURLs = photoURLs;
    }
}
