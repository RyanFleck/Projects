/**
 * 
 */
package ca.rcf.hdb3.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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

	public static void run() {
		App.dbg("Starting client...");

		try {
			clientSocket = new Socket("localhost", 7000);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		out.println(HDB3.encode("CONFIRM-ME"));
		String confirmation = "";
		try {
			confirmation = in.readLine();
			System.out.println("Got: " + confirmation);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (!HDB3.decode(confirmation).contains("GOOD2GO")) {
			System.out.println("Confirmation was incorrect.");
			System.exit(1);
		} else {
			System.out.println("Confirmation was good!");
		}

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

				String message = s;
				if (App.isBinary(message)) {
					message = HDB3.rawHDB3encode(message);
				} else {
					message = HDB3.encode(message);
				}
				String response = sendTransmission(message);

				System.out.println("\nRecieved:\n"+response);
				System.out.println(HDB3.decode(response));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static String sendTransmission(String s) throws IOException {
		out.println(s);
		return (String) in.readLine();
	}
}
