package store.items;

/**
 * Describes a catalog item for on-line store. The itemID uniquely identifies
 * the item, the short description gives brief info like the book title and
 * author, the long description describes the item in a couple of sentences, and
 * the cost gives the current per-item price. Both the short and long
 * descriptions can contain HTML markup.
 * <P>
 * Based on Core Servlets and JavaServer Pages 2nd Edition from Prentice Hall
 * and Sun Microsystems Press, http://www.coreservlets.com/. &copy; 2003 Marty
 * Hall; may be freely used or adapted.
 */
public class CatalogItem {

    public static final String KIDS = "kids";
    public static final String TECH = "tech";
    public static final String COOK = "cook";
    private String category;
    private String itemID;
    private String shortDescription;
    private String longDescription;
    private double cost;

    public CatalogItem(String category, String itemID, String shortDescription,
            String longDescription, double cost) {
        this.category = category;
        this.itemID = itemID;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.cost = cost;
    }

    public String getCategory() {
        return (category);
    }

    protected void setCategory(String category) {
        this.category = category;
    }

    public String getItemID() {
        return (itemID);
    }

    protected void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getShortDescription() {
        return (shortDescription);
    }

    protected void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return (longDescription);
    }

    protected void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getCost() {
        return (cost);
    }

    protected void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isKids() {
        return this.category.equals(KIDS);
    }

    public boolean isTech() {
        return this.category.equals(TECH);
    }

    public boolean isCook() {
        return this.category.equals(COOK);
    }
}
