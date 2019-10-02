/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import beans.UserData;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author ssome
 */
public class DBHelper {

    public static User findUser(EntityManager em, String id) {
        User u = em.find(User.class, id);
        return u;
    }

    public static List findUsersByName(EntityManager em, String name) {
        Query query = em.createQuery(
                "SELECT u FROM User u"
                + " WHERE u.NAME = :userName");
        query.setParameter("userName", name);
        return performQuery(query);
    }

    public static List findUsersByBirthDate(EntityManager em, String sdate) {
        try {
            Date bdate = Date.valueOf(sdate);
            Query query = em.createQuery(
                    "SELECT u FROM User u"
                    + " WHERE u.BIRTHDATE = :bdate");
            query.setParameter("bdate", bdate);
            return performQuery(query);
        } catch (IllegalArgumentException e) {
        }
        return null;
    }

    private static List performQuery(final Query query) {
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        ArrayList<User> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }

    public static boolean addUser(EntityManager em, UserTransaction utx, UserData userData) {
        try {
            utx.begin();
            User nuser = new User();
            nuser.setUSER_ID(userData.getId());
            nuser.setNAME(userData.getName());
            nuser.setBIRTHDATE(Date.valueOf(userData.getBirthdate()));
            em.persist(nuser);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
