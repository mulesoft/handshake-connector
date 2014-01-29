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
public class Item extends HandshakeObject {
    private String sku;
    private String name;
    private String longDesc;
    private String barcode;
    private String unitPrice;
    private Integer minQty;
    private Integer multQty;
    private Category category;
    private Integer categoryPosition;
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

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getMinQty() {
		return minQty;
	}

	public void setMinQty(Integer minQty) {
		this.minQty = minQty;
	}

	public Integer getMultQty() {
		return multQty;
	}

	public void setMultQty(Integer multQty) {
		this.multQty = multQty;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getCategoryPosition() {
		return categoryPosition;
	}

	public void setCategoryPosition(Integer categoryPosition) {
		this.categoryPosition = categoryPosition;
	}

	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}

	public Map<String, String> getAdditionalPrices() {
		return additionalPrices;
	}

	public void setAdditionalPrices(Map<String, String> additionalPrices) {
		this.additionalPrices = additionalPrices;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<String> getImageURLs() {
		return imageURLs;
	}

	public void setImageURLs(List<String> imageURLs) {
		this.imageURLs = imageURLs;
	}

	public List<String> getThumbnailURLs() {
		return thumbnailURLs;
	}

	public void setThumbnailURLs(List<String> thumbnailURLs) {
		this.thumbnailURLs = thumbnailURLs;
	}

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}

	@Override
    public String getResourceUri() {
        return this.resourceUri;
    }
}
