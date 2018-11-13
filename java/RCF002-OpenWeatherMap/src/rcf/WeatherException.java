package rcf;

/**
 * 
 */
public class WeatherException extends Exception {

	private static final long serialVersionUID = -8635695614255201896L;

	/**
	 * 
	 */
	public WeatherException() {
		super();
	}

	/**
	 * @param msg
	 */
	public WeatherException(String msg) {
		super(msg);
	}

	/**
	 * @param msg
	 * @param thw
	 */
	public WeatherException(String msg, Throwable thw) {
		super(msg, thw);
	}
}
