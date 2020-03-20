/**
 * 
 */
package ca.rcf.hdb3;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * @author Ryan Fleck
 * 
 */
public class App {

	@Parameter(description = "Files to process.")
	private List<String> parameters = new ArrayList<>();

	@Parameter(names = { "-v", "--verbose" }, description = "Enable debugging output")
	private boolean VERBOSE = false;

	@Parameter(names = { "-r", "--repl" }, description = "Enter a REPL instead of using a file input")
	private boolean STARTCLI = false;

	public static boolean debug = true; // false;

	public static void main(String[] args) {
		System.out.println("[rcf] HDB3 Encoder, use -r for REPL, or -v for debugging messages.");

		App app = new App();
		JCommander.newBuilder().addObject(app).build().parse(args);

		app.run();

	}

	public void run() {

		if (VERBOSE) {
			System.out.println("[dbg] Using verbose logging.");
			debug = true;
		}

		if (STARTCLI) {
			System.out.println("Starting REPL.");
		}
	}

	public static void dbg(String s) {
		if (debug)
			System.out.println(s);
	}

}
