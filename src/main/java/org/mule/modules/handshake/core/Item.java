/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((additionalPrices == null) ? 0 : additionalPrices.hashCode());
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((categoryPosition == null) ? 0 : categoryPosition.hashCode());
		result = prime * result + ((imageURLs == null) ? 0 : imageURLs.hashCode());
		result = prime * result + ((longDesc == null) ? 0 : longDesc.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((minQty == null) ? 0 : minQty.hashCode());
		result = prime * result + ((multQty == null) ? 0 : multQty.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((resourceUri == null) ? 0 : resourceUri.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((thumbnailURL == null) ? 0 : thumbnailURL.hashCode());
		result = prime * result + ((thumbnailURLs == null) ? 0 : thumbnailURLs.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		result = prime * result + ((variants == null) ? 0 : variants.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (additionalPrices == null) {
			if (other.additionalPrices != null)
				return false;
		} else if (!additionalPrices.equals(other.additionalPrices))
			return false;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categoryPosition == null) {
			if (other.categoryPosition != null)
				return false;
		} else if (!categoryPosition.equals(other.categoryPosition))
			return false;
		if (imageURLs == null) {
			if (other.imageURLs != null)
				return false;
		} else if (!imageURLs.equals(other.imageURLs))
			return false;
		if (longDesc == null) {
			if (other.longDesc != null)
				return false;
		} else if (!longDesc.equals(other.longDesc))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (minQty == null) {
			if (other.minQty != null)
				return false;
		} else if (!minQty.equals(other.minQty))
			return false;
		if (multQty == null) {
			if (other.multQty != null)
				return false;
		} else if (!multQty.equals(other.multQty))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (resourceUri == null) {
			if (other.resourceUri != null)
				return false;
		} else if (!resourceUri.equals(other.resourceUri))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (thumbnailURL == null) {
			if (other.thumbnailURL != null)
				return false;
		} else if (!thumbnailURL.equals(other.thumbnailURL))
			return false;
		if (thumbnailURLs == null) {
			if (other.thumbnailURLs != null)
				return false;
		} else if (!thumbnailURLs.equals(other.thumbnailURLs))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		if (variants == null) {
			if (other.variants != null)
				return false;
		} else if (!variants.equals(other.variants))
			return false;
		return true;
	}
	
	
}
