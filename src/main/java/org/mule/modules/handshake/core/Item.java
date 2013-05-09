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
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of an Item resource in Handshake
 * http://www.handshake-app.com/help/kb/api/item-resource
 * 
 * @author marianosimone
 */
public class Item extends HandshakeObjectLightOwner {
    private String sku;
    private String name;
    private String longDesc;
    private String barcode;
    private String unitPrice;
    private int minQty;
    private int multQty;
    private Category category;
    private int categoryPosition;
    private List<Variant> variants;
    private Map<String, String> additionalPrices;
    private String manufacturer;
    private List<String> imageURLs;
    private List<String> thumbnailURLs;
    private String thumbnailURL;
    @SerializedName("resource_uri")
    private String resourceUri;

    public String getSku() {
        return sku;
    }
    public void setSku(final String sku) {
        this.sku = sku;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public String getLongDesc() {
        return longDesc;
    }
    public void setLongDesc(final String longDesc) {
        this.longDesc = longDesc;
    }
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }
    public String getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(final String unitPrice) {
        this.unitPrice = unitPrice;
    }
    public int getMinQty() {
        return minQty;
    }
    public void setMinQty(final int minQty) {
        this.minQty = minQty;
    }
    public int getMultQty() {
        return multQty;
    }
    public void setMultQty(final int multQty) {
        this.multQty = multQty;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(final Category category) {
        this.category = category;
    }
    public int getCategoryPosition() {
        return categoryPosition;
    }
    public void setCategoryPosition(final int categoryPosition) {
        this.categoryPosition = categoryPosition;
    }
    public List<Variant> getVariants() {
        return variants;
    }
    public void setVariants(final List<Variant> variants) {
        this.variants = variants;
    }
    public Map<String, String> getAdditionalPrices() {
        return additionalPrices;
    }
    public void setAdditionalPrices(final Map<String, String> additionalPrices) {
        this.additionalPrices = additionalPrices;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public List<String> getImageURLs() {
        return imageURLs;
    }
    public void setImageURLs(final List<String> imageURLs) {
        this.imageURLs = imageURLs;
    }
    public List<String> getThumbnailURLs() {
        return thumbnailURLs;
    }
    public void setThumbnailURLs(final List<String> thumbnailURLs) {
        this.thumbnailURLs = thumbnailURLs;
    }
    public String getThumbnailURL() {
        return thumbnailURL;
    }
    public void setThumbnailURL(final String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }
    @Override
    public String getResourceUri() {
        return this.resourceUri;
    }
}
