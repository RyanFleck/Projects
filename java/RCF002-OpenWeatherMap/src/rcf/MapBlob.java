package rcf;

public interface MapBlob {

	void prove();

	String getWeather(String cityName) throws WeatherException;

}
