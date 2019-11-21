package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ssome, Ryan Fleck
 */
public class OpenWeatherClient {

    /*
     * Note to marker- I'm not using my own OpenWeatherMap API key here.
     */
    private final String APPID_HEADER = System.getenv("OWM_KEY");

    private final String baseUrl = "http://api.openweathermap.org/data/2.5/";
    private final String resource = "weather";
    private final Client client;

    public OpenWeatherClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
    }

    public String currentWeatherAtCity(String cityName, String countryCode) throws Exception {
        String jsonResponse = client.target(baseUrl)
                .path(resource)
                .queryParam("q", cityName + "," + countryCode)
                .queryParam("appid", APPID_HEADER)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        return jsonResponse;
    }

}
