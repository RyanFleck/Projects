/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author ssome
 */
public class WeatherConditionsFactory {

    public static double round(double value, int places) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static WeatherConditions create(String jsonResponse) throws Exception {
        JsonReader reader = Json.createReader(new StringReader(jsonResponse));
        JsonObject jsobj = reader.readObject();
        reader.close();
        int cod = jsobj.getInt("cod");
        if (cod != 200) {
            throw new Exception();
        }
        JsonArray weather = jsobj.getJsonArray("weather");
        JsonObject main = jsobj.getJsonObject("main");
        JsonObject wind = jsobj.getJsonObject("wind");
        String city = jsobj.getString("name");
        String mainCondition = weather.getJsonObject(0).getString("main");

        double temperature = tempN.doubleValue() - 273.15; // temp in Celcius
        JsonNumber pressureN = main.getJsonNumber("pressure");
        double pressure = pressureN.doubleValue(); //hPa
        JsonNumber humidityN = main.getJsonNumber("humidity");
        double humidity = humidityN.doubleValue();
        JsonNumber windspeedN = wind.getJsonNumber("speed");
        double windspeed = windspeedN.doubleValue();
        WeatherConditions wconds = new WeatherConditions();
        wconds.setCity(city);
        wconds.setHumidity(humidity);
        wconds.setMainCondition(mainCondition);
        wconds.setPressure(pressure);
        wconds.setWindspeed(windspeed);
        wconds.setTemperature(round(temperature, 2));
        return wconds;
    }

}
