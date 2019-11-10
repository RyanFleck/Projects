/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rcf.primefaces.intro.theme;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author rflec028
 */
@Named("themeDao")
@RequestScoped
public class ThemeDAOImpl {

    private ArrayList<String> themes;

    @PostConstruct
    public void init() {
        themePrep();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private void themePrep() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        themes = new ArrayList<>();
        themes.add("cupertino");
        themes.add("cruze");
        themes.add("casablanca");
        themes.add("bootstrap");
    }

    public ArrayList<String> getThemes() {
        return themes;
    }

}
