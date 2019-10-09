/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.items;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import store.persistence.CatalogItem;

public class Catalog {

    public Catalog() {

    }

    public void persist(EntityManager em, UserTransaction utx, Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Find an Item based on Id
     *
     * @param em
     * @param itemId
     * @return
     */
    public CatalogItem findItem(EntityManager em, String itemId) {
        System.out.println("DEBUG: findItem() function called.");
        CatalogItem ci = em.find(CatalogItem.class, itemId);
        return ci;
    }

    /**
     * Find all items (books) for a given category
     *
     * @param em
     * @param KIDS
     * @return
     */
    public List<CatalogItem> findByCategory(EntityManager em, String Category) {
        System.out.println("DEBUG: findByCategory() function called.");

        Query q = em.createQuery("SELECT c FROM CatalogItem c WHERE c.category = :Category");
        q.setParameter("Category", Category);
        List<CatalogItem> res = q.getResultList();
        debugPrintList(res);
        return res.isEmpty() ? null : res;

    }

    /**
     * Persists an Item
     *
     * @param em
     * @param utx
     * @param id
     * @param shortDescription
     * @param longDescription
     * @param cost
     * @param category
     * @return
     */
    public boolean addItem(EntityManager em, UserTransaction utx, String id, String shortDescription, String longDescription, double cost, String category) {
        System.out.println("DEBUG: addItem() function called.");

        try {
            utx.begin();
            CatalogItem ni = new CatalogItem();
            ni.setCategory(category);
            ni.setItemID(id);
            ni.setShortDescription(shortDescription);
            ni.setLongDescription(longDescription);
            ni.setCost(cost);
            em.persist(ni);
            utx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void debugPrintList(List<CatalogItem> x) {
        System.out.println("Items:");
        for (CatalogItem y : x) {
            System.out.println(y.getLongDescription());
        }
    }

}
