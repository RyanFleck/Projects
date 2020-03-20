/**
 * 
 */
package ca.rcf.hdb3.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import ca.rcf.hdb3.App;
import ca.rcf.hdb3.conversion.HDB3;

/**
 * @author Ryan Fleck
 *
 */
public class Server {
	private static int port = 7000;
	private static ServerSocket ss;

	public static void run() {
		App.dbg("Starting server...");

		try {
			ss = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		while (true) {
			try {
				new ConversionServiceClient(ss.accept()).start();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void stop() {
		try {
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class ConversionServiceClient extends Thread {
		private Socket clientSocket;
		private PrintWriter out;
		private BufferedReader in;

		public ConversionServiceClient(Socket socket) {
			this.clientSocket = socket;
		}

		public void run() {
			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				System.out.println("User connected. Waiting for greeting.");
				String greeting = in.readLine();
				System.out.println("Got: " + greeting);
				if (HDB3.decode(greeting).contains("CONFIRM-ME")) {
					System.out.println("Great, sending back confirmation...");
					out.println(HDB3.encode("GOOD2GO"));
				}else {
					System.out.println("Greeting incorrect.");
				}
				
				String clientInput;
				while ((clientInput = in.readLine()) != null) {
					if (clientInput.startsWith("quit") || clientInput.startsWith("exit")) {
						out.println("\nParting is such sweet sorrow!\n");
						break;
					}

					String message = clientInput;
					if (App.isBinary(clientInput)) {
						message = HDB3.rawHDB3decode(message);
					} else {
						message = HDB3.decode(message);
					}

					// Send to client
					out.println(HDB3.encode(message));
				}

				in.close();
				out.close();
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
