package org.mule.modules.handshake.core;

import java.util.List;
import java.util.Map;

/**
 * Representation of an Item resource in Handshake
 * http://www.handshake-app.com/help/kb/api/item-resource
 * 
 * @author marianosimone
 */
public class Item {
    private String sku;
    private String name;
    private String longDesc;
    private String barcode;
    private double unitPrice;
    private int minQty;
    private int multQty;
    private Category category;
    private int categoryPosition;
    private List<Variant> variants;
    private Map<String, List<String>> dimensions;
    private Map<String, String> additionalPrices;
    private Manufacturer manufacturer;
    private List<String> imageURLs;
    private List<String> thumbnailURLs;
    private String thumbnailURL;

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
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public int getMinQty() {
        return minQty;
    }
    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }
    public int getMultQty() {
        return multQty;
    }
    public void setMultQty(int multQty) {
        this.multQty = multQty;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public int getCategoryPosition() {
        return categoryPosition;
    }
    public void setCategoryPosition(int categoryPosition) {
        this.categoryPosition = categoryPosition;
    }
    public List<Variant> getVariants() {
        return variants;
    }
    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
    public Map<String, List<String>> getDimensions() {
        return dimensions;
    }
    public void setDimensions(Map<String, List<String>> dimensions) {
        this.dimensions = dimensions;
    }
    public Map<String, String> getAdditionalPrices() {
        return additionalPrices;
    }
    public void setAdditionalPrices(Map<String, String> additionalPrices) {
        this.additionalPrices = additionalPrices;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer) {
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
}
