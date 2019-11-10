/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author rcfle
 */
@SessionScoped
@Named("currentUser")
public class CurrentUser implements Serializable {

    private String currentTheme = "cupertino";

    public CurrentUser() {
        System.out.println("A user object has been created.");
    }

    /**
     * @return the currentTheme
     */
    public String getCurrentTheme() {
        System.out.println("Grabbing user theme " + currentTheme);
        return currentTheme;
    }

    /**
     * @param currentTheme the currentTheme to set
     */
    public void setCurrentTheme(String currentTheme) {
        System.out.println("Switch theme to " + currentTheme);
        this.currentTheme = currentTheme;
    }
}
