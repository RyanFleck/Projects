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

				/*
				 * Exchange a greeting with the user on connect, to ensure the user can
				 * successfully translate and send HDB3 messages.
				 */
				System.out.println("\nSETUP\nUser connected. Waiting for greeting.");
				String greeting = in.readLine();
				System.out.println("Got: " + greeting);
				if (HDB3.decode(greeting).contains("request-to-send")) {
					System.out.println("Great, sending back confirmation...");
					out.println(HDB3.encode("clear-to-send"));
				} else {
					System.out.println("Greeting incorrect.");
				}

				/*
				 * Begin monitoring the input stream for messages, and convert each back from
				 * HDB3 on receipt.
				 */
				String clientInput;
				while ((clientInput = in.readLine()) != null) {
					System.out.println("\n\nINCOMING TRANSMISSION");

					// Requirement 6 : Send receipt back to user.
					System.out.println("Send client receipt :");
					out.println(HDB3.encode("GR8"));

					// Requirement 7: Decode HDB3 stream to original format.
					System.out.println("\nIncoming HDB-3 :  " + clientInput);
					clientInput = HDB3.decode(clientInput);
					System.out.println("Got:\n\t" + clientInput);
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
