/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.StringReader;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ryan Fleck <Ryan.Fleck@protonmail.com>
 */
@Named(value = "weatherBean")
@RequestScoped
public class WeatherBean {

    private double lat = 45.42;
    private double lon = -75.69;
    private double result;

    private final String APPID_HEADER = System.getenv("OWM_KEY");
    private final String baseUrl = "http://api.openweathermap.org/data/2.5/";
    private final String resource = "weather";
    private Client client;

    @PostConstruct
    public void init() {
        System.out.println("Weather bean init!");
        // I KNOW this should be shared and session scoped.
        this.client = javax.ws.rs.client.ClientBuilder.newClient();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void checkWeather() {

        String jsonResponse = client.target(baseUrl)
                .path(resource)
                .queryParam("lat", this.lat)
                .queryParam("lon", this.lon)
                .queryParam("appid", APPID_HEADER)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println(jsonResponse);

        JsonReader reader = Json.createReader(new StringReader(jsonResponse));
        JsonObject jsobj = reader.readObject();
        reader.close();

        int cod = jsobj.getInt("cod");
        if (cod != 200) {
            this.result = (float) 0.0;
        }

        JsonObject main = jsobj.getJsonObject("main");
        JsonNumber tempN = main.getJsonNumber("temp");
        this.result = tempN.doubleValue() - 273.15; // temp in Celcius

    }

    /**
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double result) {
        this.result = result;
    }
}
