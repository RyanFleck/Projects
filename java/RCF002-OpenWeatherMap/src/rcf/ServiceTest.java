/**
 * 
 */
package rcf;

/**
 * @author Ryan Fleck
 *
 */
public class ServiceTest {

	/**
	 * @param args Command Line Input.
	 */
	public static void main(String[] args) {
		
		//Test debug method:
		dbg("Hello"+" World");
		dbg(null);
		
		WeatherService mb = new DefaultWeatherService();
		mb.prove();
		

	}
	
	/**
	 * Stand-in for logging methods in TeamSite.
	 * 
	 * @param s Object to print to the console.
	 */
	public static void dbg(Object s) {
		try {
			System.out.println("[DBG] "+s.toString());
		}catch(Exception e){
			System.out.println("[DBG] No toString() for Object. Error: "+e.toString());
		}
	}

}
