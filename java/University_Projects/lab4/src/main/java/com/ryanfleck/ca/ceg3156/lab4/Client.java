package com.ryanfleck.ca.ceg3156.lab4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		run();
	}

	public static void run() {
        try {
            System.out.println("Waiting for connection.....");
            InetAddress localAddress = InetAddress.getLocalHost();

            try (Socket clientSocket = new Socket(localAddress, 6000);
                 PrintWriter out = new PrintWriter(
                         clientSocket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(
                         new InputStreamReader(
                                 clientSocket.getInputStream()))) {
                System.out.println("Connected.");
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print(">> ");
                    String inputLine = scanner.nextLine();
                    String encoded = HDB3Encoder.encode(inputLine);
                    System.out.print("encoded string: " + encoded);
                    System.out.print("\n");
                    if ("quit".equalsIgnoreCase(inputLine)) {
                        break;
                    }
                    out.println(encoded);
                    String response = br.readLine();
                    String decoded = HDB3Encoder.decode(response);
                    System.out.println("Server response -> " + response);
                    System.out.println("Decoded server response -> " + decoded);
                }
            }
        } catch (IOException ex) {
            // Handle exceptions
        }
	}

}
