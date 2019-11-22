/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ssome
 */
public class WeatherConditions {
    private String mainCondition;
    private double temperature;
    private double pressure;
    private double humidity;
    private double windspeed;
    private String city;    

    /**
     * @return the mainCondition
     */
    public String getMainCondition() {
        return mainCondition;
    }

    /**
     * @param mainCondition the mainCondition to set
     */
    public void setMainCondition(String mainCondition) {
        this.mainCondition = mainCondition;
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the pressure
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the humidity
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the windspeed
     */
    public double getWindspeed() {
        return windspeed;
    }

    /**
     * @param windspeed the windspeed to set
     */
    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
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
}
