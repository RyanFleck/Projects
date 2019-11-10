 
package com.rcf.primefaces.lib.linkedin.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * From the LinkedIn Learning course 'Learning PrimeFaces'
 * @author Eyitayo Koleoso
 */
public class Product implements Serializable {
    private String SKU;
    private long productId;
    private List<String> images;
    private String productDesc;
    private String productTitle;
    private BigDecimal pricePer;

    /**
     * @return the SKU
     */
    public String getSKU() {
        return SKU;
    }

    /**
     * @param SKU the SKU to set
     */
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    /**
     * @return the productId
     */
    public long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * @return the images
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /**
     * @return the productDesc
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * @param productDesc the productDesc to set
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     * @return the productTitle
     */
    public String getProductTitle() {
        return productTitle;
    }

    /**
     * @param productTitle the productTitle to set
     */
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.SKU);
        hash = 11 * hash + (int) (this.productId ^ (this.productId >>> 32));
        hash = 11 * hash + Objects.hashCode(this.productTitle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.productId != other.productId) {
            return false;
        }
        if (!Objects.equals(this.SKU, other.SKU)) {
            return false;
        }
        if (!Objects.equals(this.productTitle, other.productTitle)) {
            return false;
        }
        return true;
    }

    public BigDecimal getPricePer() {
        return pricePer;
    }

    public void setPricePer(BigDecimal pricePer) {
        this.pricePer = pricePer;
    }

    @Override
    public String toString() {
        return "Product{" + "SKU=" + SKU + ", productId=" + productId + ", productTitle=" + productTitle + ", pricePer=" + pricePer + '}';
    }
    
    
    
}
