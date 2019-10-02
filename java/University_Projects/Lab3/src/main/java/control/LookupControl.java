/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import beans.UserData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.DBHelper;
import persistence.User;

/**
 *
 * @author ssome
 */
@Named(value = "lookupControl")
@RequestScoped
public class LookupControl implements Serializable {

    @Inject
    private UserData userData;
    @PersistenceContext
    EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of LookupControl
     */
    public LookupControl() {
    }

    public void lookup() {
        List<User> results = new ArrayList();
        if (!"".equals(userData.getId())) {
            // lookup by id
            results = getUserById(em, userData);
        } else if (!"".equals(userData.getName())) {
            // lookup by name
            results = getUsersByName(em, userData);
        } else if (!"".equals(userData.getBirthdate())) {
            // lookup by birthdate
            results = getUsersByBirthDate(em, userData);
        }
        userData.setLookupResults(results);
    }

    public void add() {
        if (DBHelper.addUser(em, utx, userData)) {
            userData.setAddstatus("The User Was Successfuly Added");
        } else {
            userData.setAddstatus("Addition of the User Failed");
        }
    }

    /**
     * Find a user by id and check if any that the other fields are valid
     */
    private List<User> getUserById(EntityManager em, UserData userData) {
        ArrayList<User> result = new ArrayList<>();
        User user = DBHelper.findUser(em, userData.getId());
        if (user != null && user.matches(userData)) {
            result.add(user);
        }
        return result;
    }

    private List<User> getUsersByName(EntityManager em, UserData userData) {
        List<User> allresults = DBHelper.findUsersByName(em, userData.getName());
        if (allresults == null) {
            return null;
        }
        return checkResults(allresults, userData);
    }

    private List getUsersByBirthDate(EntityManager em, UserData userData) {
        List<User> allresults = DBHelper.findUsersByBirthDate(em, userData.getBirthdate());
        if (allresults == null) {
            return null;
        }
        return checkResults(allresults, userData);
    }

    private List<User> checkResults(List<User> allresults, UserData userData) {
        ArrayList<User> results = new ArrayList<>();
        for (User user : allresults) {
            if (user.matches(userData)) {
                results.add(user);
            }
        }
        return results;
    }
}
