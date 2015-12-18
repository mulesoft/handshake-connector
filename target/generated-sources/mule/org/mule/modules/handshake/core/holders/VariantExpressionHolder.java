
package org.mule.modules.handshake.core.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class VariantExpressionHolder
    extends HandshakeObjectExpressionHolder
{

    protected Object sku;
    protected String _skuType;
    protected Object unitPrice;
    protected BigDecimal _unitPriceType;
    protected Object barcode;
    protected String _barcodeType;
    protected Object resourceUri;
    protected String _resourceUriType;

    /**
     * Sets sku
     * 
     * @param value Value to set
     */
    public void setSku(Object value) {
        this.sku = value;
    }

    /**
     * Retrieves sku
     * 
     */
    public Object getSku() {
        return this.sku;
    }

    /**
     * Sets unitPrice
     * 
     * @param value Value to set
     */
    public void setUnitPrice(Object value) {
        this.unitPrice = value;
    }

    /**
     * Retrieves unitPrice
     * 
     */
    public Object getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Sets barcode
     * 
     * @param value Value to set
     */
    public void setBarcode(Object value) {
        this.barcode = value;
    }

    /**
     * Retrieves barcode
     * 
     */
    public Object getBarcode() {
        return this.barcode;
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
