/**
 * 
 */
package rcf;

/**
 * @author rflec028
 *
 */
public class DefaultWeatherService implements WeatherService {
	public DefaultWeatherService() {

	}

	/*
	 * Important that items like this are _static_ so they can only be called by an
	 * instantiated object.
	 */

	@Override
	public void prove() {
		System.out.println("It works.");
	}

	@Override
	public String getWeather(String cityName) throws WeatherException {
		// TODO Auto-generated method stub
		return null;
	}
}
