/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.WeatherConditions;
import services.OpenWeatherClient;

/**
 *
 * @author ssome
 */
@Named(value = "weatherBean")
@RequestScoped
public class WeatherBean {

    private String country;
    private String city;
    private boolean renderOK;
    WeatherConditions conditions;

    /**
     * Creates a new instance of WeatherBean
     */
    public WeatherBean() {
    }

    @PostConstruct
    private void init() {
        conditions = new WeatherConditions();
        renderOK = false;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the mainCondition
     */
    public String getMainCondition() {
        return conditions.getMainCondition();
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {
        return conditions.getTemperature();
    }

    /**
     * @return the pressure
     */
    public double getPressure() {
        return conditions.getPressure();
    }

    /**
     * @return the humidity
     */
    public double getHumidity() {
        return conditions.getHumidity();
    }

    /**
     * @return the windspeed
     */
    public double getWindspeed() {
        return conditions.getWindspeed();
    }

    public boolean getRenderOK() {
        return renderOK;
    }

    public String getResultCity() {
        return conditions.getCity();
    }

    public void getConditions(ActionEvent actionEvent) {
        OpenWeatherClient client = new OpenWeatherClient();
        try {
            conditions = client.currentWeatherAtCity(city, country);
            renderOK = true;
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("City Not Found");
            message.setDetail("Could Not Find Current Conditions For" + city);
            context.addMessage("", message);
        }
    }

}
