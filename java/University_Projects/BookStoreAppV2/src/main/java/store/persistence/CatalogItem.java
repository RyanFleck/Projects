/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ssome
 */
@Entity
@Table(name="CatalogItems8276723")
public class CatalogItem implements Serializable {
  public static final String KIDS = "kids";
  public static final String TECH = "tech";
  private static final long serialVersionUID = 1L;
  @Id
  private String itemID;
  private String category;
  private String shortDescription;
  private String longDescription;
  private double cost;

  public CatalogItem() {
  }

  public CatalogItem(String category, String itemID, String shortDesc, String longDesc, double cost) {
    this.category = category;
    this.itemID = itemID;
    this.shortDescription = shortDesc;
    this.longDescription = longDesc;
    this.cost = cost;
  }

  public String getItemID() {
    return(itemID);
  }

  protected void setItemID(String itemID) {
    this.itemID = itemID;
  }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogItem)) {
            return false;
        }
        CatalogItem other = (CatalogItem) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "store.persistence.CatalogItem[ id=" + itemID + " ]";
    }
      public String getCategory() {
    return(category);
  }

  protected void setCategory(String category) {
    this.category = category;
  }
  

  public String getShortDescription() {
    return(shortDescription);
  }

  protected void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return(longDescription);
  }

  protected void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public double getCost() {
    return(cost);
  }

  protected void setCost(double cost) {
    this.cost = cost;
  }

}
