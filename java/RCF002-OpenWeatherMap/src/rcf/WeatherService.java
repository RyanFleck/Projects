package rcf;

import org.dom4j.Document;

/**
 * @author Ryan Fleck
 * 
 *         WeatherService utilizes the OpenWeatherMap API to return XML from the OpenWeatherMap service.
 * 
 *         IMPORTANT NOTE: config-default.xml must be copied to default.xml and populated with an OWM API key before use.
 *
 */
public interface WeatherService {

    /**
     * @param cityName A String including city and country code in the format "Ottawa,CA".
     * @return An XML document with the current weather.
     * @throws WeatherException if it's raining too hard and the weathermen need to stay inside.
     */
    Document getWeather(String cityName) throws WeatherException;

}
