/**
 * 
 */
package ca.rcf.hdb3;

/**
 * @author Ryan Fleck
 * 
 */
public class HDB3 {

	public static String rawHDB3encode(String s) {
		StringBuilder sb = new StringBuilder();

		char[] bc = s.toCharArray();

		int pos = 0;
		boolean last_bit_low = true;
		boolean even_parity = true;
		while (true) {

			if (bc[pos] == '1')
				even_parity = !even_parity;

			// Check if next three bits are also 0.
			if (bc[pos] == '0' && bc[pos + 1] == '0' && bc[pos + 2] == '0' && bc[pos + 3] == '0') {
				if (last_bit_low) {
					sb.append("+00+");
				} else {
					sb.append("+00+");
				}
				pos += 4;

			} else if (bc[pos] == 1) {
				if (last_bit_low) {
					sb.append("+");
				} else {
					sb.append("-");
				}
				pos += 1;
			} else {

			}

			// Exit loop.
			if (pos >= bc.length)
				break;
		}
		return "";
	}

	public static String rawHDB3decode(String s) {
		return "";
	}

	public static String encode(String s) {
		App.dbg("\n\n[dbg] Converting string to HDB3.");
		App.dbg("First converting to binary string...");
		return rawHDB3encode(Binary.encode(s));
	}

	public static String decode(String s) {
		App.dbg("\n\n[dbg] Decoding HDB3 string.");
		return Binary.decode(rawHDB3decode(s));
	}
}
