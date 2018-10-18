/**
 * 
 */
package rcf;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @author rflec028
 * 
 *         External Content Service is assumed/emulated.
 *
 */
public class DefaultWeatherService implements WeatherService {
	
	private String hardURL;
	private String apiKey;
	
	public DefaultWeatherService() {
		// URL and Key stored in environment variables.
		//Dotenv env = Dotenv.load();
		hardURL = "https://api.openweathermap.org/data/2.5/weather?mode=xml&q="; //?q={city name}
		//apiKey = env.get("API_KEY");
		//dbg("API Key: "+apiKey);
		
	}

	/*
	 * Important that items like this are _static_ so they can only be called by an
	 * instantiated object.
	 */

	@Override
	public void prove() {
		System.out.println("DefaultWeatherService can be accessed.");
	}

	@Override
	public Document getWeather(String cityName) throws WeatherException {
		try {
			SAXReader reader = new SAXReader();
			Document weatherData = reader.read(new URL(hardURL.concat(cityName)).openStream());
			return weatherData;
		} catch(Exception e) {
			dbg(e.toString());
			return null;
		}
		
	}
	
	private static void dbg(Object s) {
		try {
			System.out.println("[DefaultWeatherService] "+s.toString());
		}catch(Exception e){
			System.out.println("[DefaultWeatherService] No toString() for Object. Error: "+e.toString());
		}
	}
}
