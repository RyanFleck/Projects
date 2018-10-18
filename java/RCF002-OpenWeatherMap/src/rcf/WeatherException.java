package rcf;

public class WeatherException extends Exception {

	private static final long serialVersionUID = -8635695614255201896L;

	public WeatherException() {
		super();
	}

	public WeatherException(String msg) {
		super(msg);
	}

	public WeatherException(String msg, Throwable thw) {
		super(msg, thw);
	}
}
