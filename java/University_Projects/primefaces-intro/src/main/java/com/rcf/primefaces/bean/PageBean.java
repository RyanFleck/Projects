/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rcf.primefaces.bean;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Ryan Fleck <Ryan.Fleck@protonmail.com>
 */
@ViewScoped
@Named("pageBean")
public class PageBean implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void openPopup() {
        PrimeFaces.current().executeScript("PF('welcomeDialog').show();");
    }
    
    public void openPageDialog(){
        PrimeFaces.current().dialog().openDynamic("/welcomePrimefaces_reduced.xhtml");
    }

}
