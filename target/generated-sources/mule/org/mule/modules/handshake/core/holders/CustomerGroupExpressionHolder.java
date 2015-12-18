
package org.mule.modules.handshake.core.holders;

import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class CustomerGroupExpressionHolder
    extends HandshakeObjectExpressionHolder
{

    protected Object name;
    protected String _nameType;
    protected Object id;
    protected String _idType;
    protected Object currency;
    protected String _currencyType;
    protected Object resourceUri;
    protected String _resourceUriType;

    /**
     * Sets name
     * 
     * @param value Value to set
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Retrieves name
     * 
     */
    public Object getName() {
        return this.name;
    }

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
     * Sets currency
     * 
     * @param value Value to set
     */
    public void setCurrency(Object value) {
        this.currency = value;
    }

    /**
     * Retrieves currency
     * 
     */
    public Object getCurrency() {
        return this.currency;
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

}
