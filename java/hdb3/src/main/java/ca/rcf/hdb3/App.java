/**
 * 
 */
package ca.rcf.hdb3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import ca.rcf.hdb3.conversion.Binary;
import ca.rcf.hdb3.conversion.HDB3;
import ca.rcf.hdb3.networking.Client;
import ca.rcf.hdb3.networking.Server;

/**
 * @author Ryan Fleck
 * 
 */
public class App {

	// @Parameter(description = "Files to process.")
	// private List<String> parameters = new ArrayList<>();

	@Parameter(order = 3, names = { "-v", "--verbose" }, description = "Enable debugging output")
	private boolean VERBOSE = false;

	@Parameter(order = 0, names = { "-r", "--repl" }, description = "Enter a REPL instead of using a file input")
	private boolean STARTCLI = false;

	@Parameter(order = 1, names = { "-c", "--client" }, description = "Boot to CLIENT mode")
	private boolean STARTCLIENT = false;

	@Parameter(order = 2, names = { "-s", "--server" }, description = "Boot to SERVER mode")
	private boolean STARTSERVER = false;

	public static boolean debug = false; // false;
	private static JCommander j;

	public static void main(String[] args) {
		System.out.println("[rcf] Ryan Fleck - HDB3 Encoder");

		App app = new App();

		j = JCommander.newBuilder().addObject(app).build();
		j.setProgramName("java -jar hdb3.jar");
		j.parse(args);

		app.run();

	}

	public void run() {

		if (!(VERBOSE || STARTCLI || STARTCLIENT || STARTSERVER)) {
			j.usage();
			System.exit(0);
		}

		if (VERBOSE) {
			System.out.println("[dbg] Using verbose logging.");
			debug = true;
		}

		if (STARTCLIENT || STARTSERVER) {
			System.out.println("Starting remote system.");

			if (STARTCLIENT) {
				Client.run();
			} else {
				Server.run();
			}

		} else if (STARTCLI) {
			System.out.println("Starting REPL.");
			repl();
		}
	}

	public static void repl() {
		Client.printUsage();
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = "";
			try {
				System.out.print("\nCONVERT > ");
				s = br.readLine();
				if (s.startsWith("quit") || s.startsWith("exit") || s.startsWith("halt")) {
					System.out.println("\nParting is such sweet sorrow!\n");
					System.exit(0);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (isBinary(s)) {
				System.out.println("HDB-3   " + HDB3.binaryHDB3encode(s));
			} else {
				System.out.println("BINARY  " + Binary.encode(s));
				System.out.println("HDB-3   " + HDB3.encode(s));
			}
		}
	}

	public static void dbg(String s) {
		if (debug)
			System.out.println(s);
	}

	public static boolean isBinary(String s) {
		char[] ca = s.toCharArray();
		for (char c : ca) {
			if (c != '1' && c != '0')
				return false;
		}
		return true;
	}

}
