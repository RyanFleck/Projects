/**
 * 
 */
package ca.rcf.hdb3.conversion;

import ca.rcf.hdb3.App;

/**
 * @author Ryan Fleck
 * 
 */
public class Binary {

	public static String encode(String s) {
		StringBuilder sb = new StringBuilder();
		App.dbg("\n\n[dbg] Converting '" + s + "' to binary.\nBytes:");

		byte[] bytes = s.getBytes();
		for (byte b : bytes) {
			sb.append("");
			String a = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
			App.dbg(b + " -> " + a);
			sb.append(a);
		}

		String res = sb.toString();
		System.out.println("Text -> Binary :  "+res);
		return res;
	}

	public static String decode(String s) {
		App.dbg("\n\n[dbg] Converting " + s + " to UTF-8 string.");
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();

		int sum = 0;
		int bitcount = 0;
		for (int i = 0; i < chars.length; i++) {

			// Append every four bits.
			if (chars[i] == '1') {
				sum += 1 << (7 - bitcount);
			}

			bitcount++;
			App.dbg("Bit " + bitcount + ": " + chars[i]);

			if (bitcount == 8) {
				char[] x = Character.toChars(sum);

				// Overkill for printing one char, revise:
				if (App.debug) {
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("Got character ");
					stringBuilder.append(sum);
					stringBuilder.append(": ");
					stringBuilder.append(x);
					App.dbg(stringBuilder.toString());
					App.dbg(String.format("%8s", Integer.toBinaryString(sum & 0xFF)).replace(' ', '0'));
				}
				
				sb.append(x);
				sum = 0;
				bitcount = 0;
			}
		}

		String res = sb.toString();
		System.out.println("Binary -> Text :  "+res);
		return res;
	}
}
