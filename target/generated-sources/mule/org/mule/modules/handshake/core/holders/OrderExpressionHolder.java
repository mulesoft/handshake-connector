
package org.mule.modules.handshake.core.holders;

import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import org.mule.modules.handshake.core.Address;
import org.mule.modules.handshake.core.CreditCard;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.SalesOrderLine;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class OrderExpressionHolder
    extends HandshakeObjectExpressionHolder
{

    protected Object id;
    protected String _idType;
    protected Object customer;
    protected Customer _customerType;
    protected Object billTo;
    protected Address _billToType;
    protected Object shipTo;
    protected Address _shipToType;
    protected Object creditCard;
    protected CreditCard _creditCardType;
    protected Object userGroup;
    protected String _userGroupType;
    protected Object category;
    protected String _categoryType;
    protected Object lines;
    protected List<SalesOrderLine> _linesType;
    protected Object lastEdited;
    protected Date _lastEditedType;
    protected Object manufacturerIds;
    protected String _manufacturerIdsType;
    protected Object manufacturerNames;
    protected String _manufacturerNamesType;
    protected Object status;
    protected String _statusType;
    protected Object shippingMethod;
    protected String _shippingMethodType;
    protected Object paymentTerms;
    protected String _paymentTermsType;
    protected Object notes;
    protected String _notesType;
    protected Object customerPO;
    protected String _customerPOType;
    protected Object emailSent;
    protected boolean _emailSentType;
    protected Object startShipDate;
    protected String _startShipDateType;
    protected Object cancelDate;
    protected String _cancelDateType;
    protected Object freeShipping;
    protected boolean _freeShippingType;
    protected Object shipPartial;
    protected boolean _shipPartialType;
    protected Object signatureURL;
    protected String _signatureURLType;
    protected Object photoURLs;
    protected List<String> _photoURLsType;
    protected Object resourceUri;
    protected String _resourceUriType;
    protected Object totalOffDiscount;
    protected String _totalOffDiscountType;
    protected Object percentDiscount;
    protected String _percentDiscountType;

    /**
     * Sets id
     * 
     * @param value Value to set
     */
    public void setId(Object value) {
        this.id = value;
    }

    /**
     * Retrieves id
     * 
     */
    public Object getId() {
        return this.id;
    }

    /**
     * Sets customer
     * 
     * @param value Value to set
     */
    public void setCustomer(Object value) {
        this.customer = value;
    }

    /**
     * Retrieves customer
     * 
     */
    public Object getCustomer() {
        return this.customer;
    }

    /**
     * Sets billTo
     * 
     * @param value Value to set
     */
    public void setBillTo(Object value) {
        this.billTo = value;
    }

    /**
     * Retrieves billTo
     * 
     */
    public Object getBillTo() {
        return this.billTo;
    }

    /**
     * Sets shipTo
     * 
     * @param value Value to set
     */
    public void setShipTo(Object value) {
        this.shipTo = value;
    }

    /**
     * Retrieves shipTo
     * 
     */
    public Object getShipTo() {
        return this.shipTo;
    }

    /**
     * Sets creditCard
     * 
     * @param value Value to set
     */
    public void setCreditCard(Object value) {
        this.creditCard = value;
    }

    /**
     * Retrieves creditCard
     * 
     */
    public Object getCreditCard() {
        return this.creditCard;
    }

    /**
     * Sets userGroup
     * 
     * @param value Value to set
     */
    public void setUserGroup(Object value) {
        this.userGroup = value;
    }

    /**
     * Retrieves userGroup
     * 
     */
    public Object getUserGroup() {
        return this.userGroup;
    }

    /**
     * Sets category
     * 
     * @param value Value to set
     */
    public void setCategory(Object value) {
        this.category = value;
    }

    /**
     * Retrieves category
     * 
     */
    public Object getCategory() {
        return this.category;
    }

    /**
     * Sets lines
     * 
     * @param value Value to set
     */
    public void setLines(Object value) {
        this.lines = value;
    }

    /**
     * Retrieves lines
     * 
     */
    public Object getLines() {
        return this.lines;
    }

    /**
     * Sets lastEdited
     * 
     * @param value Value to set
     */
    public void setLastEdited(Object value) {
        this.lastEdited = value;
    }

    /**
     * Retrieves lastEdited
     * 
     */
    public Object getLastEdited() {
        return this.lastEdited;
    }

    /**
     * Sets manufacturerIds
     * 
     * @param value Value to set
     */
    public void setManufacturerIds(Object value) {
        this.manufacturerIds = value;
    }

    /**
     * Retrieves manufacturerIds
     * 
     */
    public Object getManufacturerIds() {
        return this.manufacturerIds;
    }

    /**
     * Sets manufacturerNames
     * 
     * @param value Value to set
     */
    public void setManufacturerNames(Object value) {
        this.manufacturerNames = value;
    }

    /**
     * Retrieves manufacturerNames
     * 
     */
    public Object getManufacturerNames() {
        return this.manufacturerNames;
    }

    /**
     * Sets status
     * 
     * @param value Value to set
     */
    public void setStatus(Object value) {
        this.status = value;
    }

    /**
     * Retrieves status
     * 
     */
    public Object getStatus() {
        return this.status;
    }

    /**
     * Sets shippingMethod
     * 
     * @param value Value to set
     */
    public void setShippingMethod(Object value) {
        this.shippingMethod = value;
    }

    /**
     * Retrieves shippingMethod
     * 
     */
    public Object getShippingMethod() {
        return this.shippingMethod;
    }

    /**
     * Sets paymentTerms
     * 
     * @param value Value to set
     */
    public void setPaymentTerms(Object value) {
        this.paymentTerms = value;
    }

    /**
     * Retrieves paymentTerms
     * 
     */
    public Object getPaymentTerms() {
        return this.paymentTerms;
    }

    /**
     * Sets notes
     * 
     * @param value Value to set
     */
    public void setNotes(Object value) {
        this.notes = value;
    }

    /**
     * Retrieves notes
     * 
     */
    public Object getNotes() {
        return this.notes;
    }

    /**
     * Sets customerPO
     * 
     * @param value Value to set
     */
    public void setCustomerPO(Object value) {
        this.customerPO = value;
    }

    /**
     * Retrieves customerPO
     * 
     */
    public Object getCustomerPO() {
        return this.customerPO;
    }

    /**
     * Sets emailSent
     * 
     * @param value Value to set
     */
    public void setEmailSent(Object value) {
        this.emailSent = value;
    }

    /**
     * Retrieves emailSent
     * 
     */
    public Object getEmailSent() {
        return this.emailSent;
    }

    /**
     * Sets startShipDate
     * 
     * @param value Value to set
     */
    public void setStartShipDate(Object value) {
        this.startShipDate = value;
    }

    /**
     * Retrieves startShipDate
     * 
     */
    public Object getStartShipDate() {
        return this.startShipDate;
    }

    /**
     * Sets cancelDate
     * 
     * @param value Value to set
     */
    public void setCancelDate(Object value) {
        this.cancelDate = value;
    }

    /**
     * Retrieves cancelDate
     * 
     */
    public Object getCancelDate() {
        return this.cancelDate;
    }

    /**
     * Sets freeShipping
     * 
     * @param value Value to set
     */
    public void setFreeShipping(Object value) {
        this.freeShipping = value;
    }

    /**
     * Retrieves freeShipping
     * 
     */
    public Object getFreeShipping() {
        return this.freeShipping;
    }

    /**
     * Sets shipPartial
     * 
     * @param value Value to set
     */
    public void setShipPartial(Object value) {
        this.shipPartial = value;
    }

    /**
     * Retrieves shipPartial
     * 
     */
    public Object getShipPartial() {
        return this.shipPartial;
    }

    /**
     * Sets signatureURL
     * 
     * @param value Value to set
     */
    public void setSignatureURL(Object value) {
        this.signatureURL = value;
    }

    /**
     * Retrieves signatureURL
     * 
     */
    public Object getSignatureURL() {
        return this.signatureURL;
    }

    /**
     * Sets photoURLs
     * 
     * @param value Value to set
     */
    public void setPhotoURLs(Object value) {
        this.photoURLs = value;
    }

    /**
     * Retrieves photoURLs
     * 
     */
    public Object getPhotoURLs() {
        return this.photoURLs;
    }

    /**
     * Sets resourceUri
     * 
     * @param value Value to set
     */
    public void setResourceUri(Object value) {
        this.resourceUri = value;
    }

    /**
     * Retrieves resourceUri
     * 
     */
    public Object getResourceUri() {
        return this.resourceUri;
    }

    /**
     * Sets totalOffDiscount
     * 
     * @param value Value to set
     */
    public void setTotalOffDiscount(Object value) {
        this.totalOffDiscount = value;
    }

    /**
     * Retrieves totalOffDiscount
     * 
     */
    public Object getTotalOffDiscount() {
        return this.totalOffDiscount;
    }

    /**
     * Sets percentDiscount
     * 
     * @param value Value to set
     */
    public void setPercentDiscount(Object value) {
        this.percentDiscount = value;
    }

    /**
     * Retrieves percentDiscount
     * 
     */
    public Object getPercentDiscount() {
        return this.percentDiscount;
    }

}
