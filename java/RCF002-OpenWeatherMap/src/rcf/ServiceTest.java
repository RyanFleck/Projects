/**
 * 
 */
package rcf;

import org.dom4j.Document;

/**
 * @author Ryan Fleck
 * 
 *         Calls the DefaultWeatherService on a few cities, proves XML data has been loaded correctly.
 * 
 *         IMPORTANT NOTE: config-default.xml must be copied to default.xml and populated with an OWM API key before use.
 *
 */
public class ServiceTest {

    /**
     * @param args Command Line Input.
     */
    public static void main(String[] args) {

        // Test debug method:
        // dbg("Hello"+" World");
        // dbg(null);

        WeatherService mb = new DefaultWeatherService();
        try {
            Document w = mb.getWeather("Ottawa,CA");
            dbg("City: " + w.selectSingleNode("//current/city").valueOf("@name"));
            dbg("Temp: " + w.selectSingleNode("//current/temperature").valueOf("@value") + "C");
        } catch (WeatherException e) {
            dbg(e.toString());
        }

    }

    /**
     * Stand-in for logging methods in TeamSite.
     * 
     * @param s Object to print to the console.
     */
    private static void dbg(Object s) {
        try {
            System.out.println("[ServiceTest] " + s.toString());
        } catch (Exception e) {
            System.out.println("[ServiceTest] No toString() for Object. Error: " + e.toString());
        }
    }

}
