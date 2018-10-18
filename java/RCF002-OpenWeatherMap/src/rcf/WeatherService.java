package rcf;

public interface WeatherService {

	void prove();

	String getWeather(String cityName) throws WeatherException;

}
