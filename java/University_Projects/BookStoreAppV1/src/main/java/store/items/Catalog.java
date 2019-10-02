/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.items;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author ssome
 */
public class Catalog {

    //private ArrayList<CatalogItem> items = new ArrayList<>();
    private TreeMap<String, CatalogItem> items = new TreeMap<>();

    public Catalog() {
        initItems();
    }

    /**
     * Initializes the Catalog with a set of sample items
     */
    private void initItems() {
        items.put("hall001", new CatalogItem(CatalogItem.TECH,
                "hall001",
                "Core Servlets and JavaServer Pages "
                + "2nd Edition (Volume 1)"
                + " by Marty Hall and Larry Brown",
                "The definitive reference on servlets "
                + "and JSP from Prentice Hall and \n"
                + "Sun Microsystems Press.Nominated for "
                + "the Nobel Prize in Literature.",
                39.95));
        items.put("hall002", new CatalogItem(CatalogItem.TECH,
                "hall002",
                "Core Web Programming, 2nd Edition "
                + "by Marty Hall and Larry Brown",
                "One stop shopping for the Web programmer. "
                + "Topics include "
                + "thorough coverage of Java 2; "
                + "including Threads, Networking, Swing, "
                + "Java 2D, RMI, JDBC, and Collections",
                49.99));
        items.put("lewis001", new CatalogItem(CatalogItem.KIDS,
                "lewis001",
                "The Chronicles of Narnia by C.S. Lewis",
                "The classic children's adventure pitting "
                + "Aslan the Great Lion and his followers "
                + "against the White Witch and the forces "
                + "of evil. Dragons, magicians, quests, "
                + "and talking animals wound around a deep "
                + "spiritual allegory.",
                19.95));
        items.put("alexander001", new CatalogItem(CatalogItem.KIDS,
                "alexander001",
                "The Prydain Series by Lloyd Alexander",
                "Humble pig-keeper Taran joins mighty "
                + "Lord Gwydion in his battle against "
                + "Arawn the Lord of Annuvin. Joined by "
                + "his loyal friends the beautiful princess "
                + "Eilonwy, wannabe bard Fflewddur Fflam,"
                + "and furry half-man Gurgi, Taran discovers "
                + "courage, nobility, and other values along "
                + "the way.",
                19.95));
        items.put("rowling001", new CatalogItem(CatalogItem.KIDS,
                "rowling001",
                "The Harry Potter Series by J.K. Rowling",
                "The first five of the popular stories "
                + "about wizard-in-training Harry Potter "
                + "topped both the adult and children's "
                + "best-seller lists.",
                59.95));
            items.put("rowling001", new CatalogItem(CatalogItem.COOK,
                "rowling001",
                "Cooking with Spice",
                "The first five of the popular stories "
                + "about wizard-in-training Harry Potter "
                + "topped both the adult and children's "
                + "best-seller lists.",
                59.95));

    }

    /**
     * @return the items
     */
    public ArrayList<CatalogItem> getItems() {
        ArrayList<CatalogItem> allItems = new ArrayList<>();
        allItems.addAll(items.values());
        return allItems;
    }

    /**
     * Find an Item based on Id
     *
     * @param itemId
     * @return
     */
    public CatalogItem getClass(String itemId) {
        return items.get(itemId);
    }

    public boolean addItem(String id, String shortDescription, String longDescription, double cost, String category) {
        CatalogItem item = items.get(id);
        if (item != null) {
            return false;
        }
        item = new CatalogItem(category, id, shortDescription, longDescription, cost);
        items.put(id, item);
        return true;
    }
}
