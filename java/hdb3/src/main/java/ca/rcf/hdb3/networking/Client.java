/**
 * 
 */
package ca.rcf.hdb3.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ca.rcf.hdb3.App;
import ca.rcf.hdb3.conversion.HDB3;

/**
 * @author Ryan Fleck
 *
 */
public class Client {

	private static PrintWriter out;
	private static BufferedReader in;
	private static Socket clientSocket;
	private static String confirmation;

	public static void run() {
		App.dbg("Starting client...");

		try {
			clientSocket = new Socket("localhost", 7000);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			/*
			 * Exchange greeting with server on connect to ensure the server can
			 * successfully decode and encode sent messages.
			 */
			System.out.println("\nSETUP\n");
			out.println(HDB3.encode("request-to-send"));
			confirmation = in.readLine();
			if (!HDB3.decode(confirmation).contains("clear-to-send")) {
				System.out.println("Confirmation was incorrect.");
				System.exit(1);
			} else {
				System.out.println("Confirmation was good!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		printUsage();

		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = "";
			try {
				System.out.print("\n\nTRANSMIT > ");
				s = br.readLine();

				if (s.startsWith("quit") || s.startsWith("exit") || s.startsWith("halt")) {
					System.out.println("\nParting is such sweet sorrow!\n");

					in.close();
					out.close();
					clientSocket.close();
					System.exit(0);
				}

				if (App.isBinary(s)) {
					s = HDB3.binaryHDB3encode(s);
				} else {
					s = HDB3.encode(s);
				}

				String response = sendTransmission(s);
				System.out.println("\nReceived HDB-3 :  " + response);
				response = HDB3.decode(response);
				if (response.startsWith("GR8")) {
					System.out.println("Server confirms receipt of submission.");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String sendTransmission(String s) throws IOException {
		out.println(s);
		return (String) in.readLine();
	}

	public static void printUsage() {
		System.out.println("\nHDB-3 REPL USAGE:\n" + " - Type '1' or '0' into the REPL to send a binary transmission\n"
				+ " - Type ASCII into the REPL to send UTF-8 binary-encoded ASCII.\n - Type 'quit', 'exit', or 'halt' to close the REPL.\n");
	}
}
