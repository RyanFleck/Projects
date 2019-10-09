/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author ssome
 */
@Named(value = "localeSwitch")
@SessionScoped
public class LocaleSwitch implements Serializable {

   private static final long serialVersionUID = 1L;
   private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
   private String language;

   private static final Map<String,Object> countries;
   
   static{
      countries = new LinkedHashMap<>();
      countries.put("English", Locale.ENGLISH);
      countries.put("Fran\u00E7ais", Locale.FRENCH);
   }

   public Map<String, Object> getCountries() {
      return countries;
   }

   public Locale getLocale() {
      return locale;
   }

   public void setLocale(Locale locale) {
      this.locale = locale;
   }

   //value change event listener
   public void localeChanged(ValueChangeEvent e){
      String newLocaleValue = e.getNewValue().toString();
      FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
      for (Map.Entry<String, Object> entry : countries.entrySet()) {
         if(entry.getValue().toString().equals(newLocaleValue)){
            locale = (Locale) entry.getValue();
            FacesContext.getCurrentInstance()
               .getViewRoot().setLocale(locale);         
         }
      }
   }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }
    
}
