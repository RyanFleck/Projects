package rcf;

import org.dom4j.Document;

public interface WeatherService {

	void prove();

	Document getWeather(String cityName) throws WeatherException;

}
