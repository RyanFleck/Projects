/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javax.faces.context.FacesContext;
import store.items.Catalog;
import store.items.CatalogItem;
import store.items.ItemOrder;

/**
 *
 * @author ssome
 */
@Named(value = "catalogBean")
@SessionScoped
public class CatalogBean implements Serializable {

    private Catalog catalog_;
    private String catalogTitle;
    private ArrayList<CatalogItem> items;
    private TreeMap<String, ItemOrder> shoppingCart = new TreeMap<>();
    private String orderItemId;
    private int updateOrderNumber;
    private double orderTotal;
    //***
    private String category;
    private String id;
    private String shortDescription;
    private String longDescription;
    private String status;
    private double cost;

    /**
     * Creates a new instance of CatalogBean
     */
    public CatalogBean() {
        catalog_ = new Catalog();
    }

    /**
     * Get the value of catalogTitle
     *
     * @return the value of catalogTitle
     */
    public String getCatalogTitle() {
        return catalogTitle;
    }

    /**
     * Set the value of catalogTitle
     *
     * @param catalogTitle new value of catalogTitle
     */
    public void setCatalogTitle(String catalogTitle) {
        this.catalogTitle = catalogTitle;
    }

    /**
     * Get the value of orderBookId
     *
     * @return the value of orderBookId
     */
    public String getOrderItemId() {
        return orderItemId;
    }

    /**
     * Set the value of orderBookId
     *
     * @param itemId new value of orderItemId
     */
    public void setOrderItemId(String itemId) {
        this.orderItemId = itemId;
    }

    /**
     * @return the items
     */
    public ArrayList<CatalogItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ArrayList<CatalogItem> items) {
        this.items = items;
    }

    /**
     * @return the updateOrderNumber
     */
    public int getUpdateOrderNumber() {
        return updateOrderNumber;
    }

    /**
     * @param updateOrderNumber the updateOrderNumber to set
     */
    public void setUpdateOrderNumber(int updateOrderNumber) {
        this.updateOrderNumber = updateOrderNumber;
    }

    /**
     * All kids books in the Catalog
     *
     * @return
     */
    public String getKidsBooks() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        catalogTitle = bundle.getString("kidsCatalogTitle");
        items = new ArrayList<>();
        for (CatalogItem item : catalog_.getItems()) {
            if (item.isKids()) {
                items.add(item);
            }
        }
        return "catalogPage";
    }

    /**
     * All tech books in the Catalog
     *
     * @return
     */
    public String getTechBooks() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        catalogTitle = bundle.getString("techCatalogTitle");
        items = new ArrayList<>();
        for (CatalogItem item : catalog_.getItems()) {
            if (item.isTech()) {
                items.add(item);
            }
        }
        return "catalogPage";
    }
    
    /**
     * All tech books in the Catalog
     *
     * @return
     */
    public String getCookBooks() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        catalogTitle = bundle.getString("cookCatalogTitle");
        items = new ArrayList<>();
        for (CatalogItem item : catalog_.getItems()) {
            if (item.isCook()) {
                items.add(item);
            }
        }
        return "catalogPage";
    }
    
    

    public void orderItem() {
        CatalogItem item = catalog_.getClass(orderItemId);
        if (item != null) {
            shoppingCart.put(orderItemId, new ItemOrder(item));
        }
    }

    public Collection getShoppingCart() {
        return shoppingCart.values();
    }

    public void updateOrder() {
        ItemOrder item = shoppingCart.get(orderItemId);
        if (item != null) {
            item.setNumItems(updateOrderNumber);
        }
    }

    /**
     * @return the orderTotal
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * @param orderTotal the orderTotal to set
     */
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * @return the orderTaxes
     */
    public double getOrderTaxes() {
        // apply 13% taxes
        double orderTaxes = orderTotal * 0.13;
        return orderTaxes;
    }

    /**
     * @return the orderShipping
     */
    public double getOrderShipping() {
        // shipping is 5% + $10
        double orderShipping = orderTotal * 0.05 + 10.0;
        return orderShipping;
    }

    public double getGrandTotal() {
        return orderTotal + getOrderTaxes() + getOrderShipping();
    }

    public String checkout() {
        orderTotal = 0.0;
        for (ItemOrder order : shoppingCart.values()) {
            orderTotal = orderTotal + order.getTotalCost();
        }
        return "checkoutPage";
    }

    //***
    /**
     * Get the value of cost
     *
     * @return the value of cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Set the value of cost
     *
     * @param cost new value of cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @param shortDescription the shortDescription to set
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * @return the longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @param longDescription the longDescription to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public void addBook() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        if (catalog_.addItem(id, shortDescription, longDescription, cost, category)) {
            status = bundle.getString("addOk");
        } else {
            status = bundle.getString("addFail");
        }
    }
}
