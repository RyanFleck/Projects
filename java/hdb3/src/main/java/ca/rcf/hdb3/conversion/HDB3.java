/**
 * 
 */
package ca.rcf.hdb3.conversion;

import ca.rcf.hdb3.App;

/**
 * @author Ryan Fleck
 * 
 */
public class HDB3 {

	public static String binaryHDB3encode(String s) {
		StringBuilder sb = new StringBuilder();

		char[] bc = s.toCharArray();

		int pos = 0;
		boolean last_violation_ct_even = true;
		int plus_since_last_v = 0;
		int minus_since_last_v = 0;
		boolean last_bit_plus = false;
		boolean first_violation = false;

		while (true) {

			String a = null;

			if (bc[pos] == '1') {
				App.dbg("Bit is 1.");
				if (!last_bit_plus) {
					a = ("+");
					plus_since_last_v++;
					last_bit_plus = true;
				} else {
					a = ("-");
					minus_since_last_v++;
					last_bit_plus = false;
				}

				pos += 1;

			} else if (((pos + 4) <= bc.length) && bc[pos] == '0' && bc[pos + 1] == '0' && bc[pos + 2] == '0'
					&& bc[pos + 3] == '0') {
				App.dbg("Bit is string of four zeroes.");

				if (!first_violation) {
					last_violation_ct_even = false;
				} else if ((plus_since_last_v - minus_since_last_v) % 2 == 0) {
					last_violation_ct_even = true;
				} else {
					last_violation_ct_even = false;
				}

				plus_since_last_v = 0;
				minus_since_last_v = 0;

				if (last_violation_ct_even) {
					String b = last_bit_plus ? "-" : "+";
					last_bit_plus = !last_bit_plus;
					a = (b + "00" + b);

				} else {
					String b = last_bit_plus ? "+" : "-";
					a = ("000" + b);
				}

				pos += 4;
				first_violation = true;

			} else {
				App.dbg("Bit is zero.");
				a = ("0");
				pos += 1;
			}

			App.dbg("Appending " + a);
			sb.append(a);

			// Exit loop.
			if (pos >= bc.length)
				break;
		}

		String res = sb.toString();
		System.out.println("Binary -> HDB3 :  " + res);
		return res;
	}

	public static String binaryHDB3decode(String s) {
		StringBuilder sb = new StringBuilder();

		char[] bc = s.toCharArray();

		boolean next_expected_positive = true;

		int pos = 0;

		while (bc[pos] == '0') {
			sb.append("0");
			pos++;
			if (pos >= bc.length)
				break;
		}

		if (pos < bc.length) {
			// Sets this value to the opposite to prime the while loop.
			App.dbg("First one is " + bc[pos]);

			while (true) {

				App.dbg("" + bc[pos]);
				
				// Check if a violation has occured:
				if ((bc[pos] == '+' && !next_expected_positive) || (bc[pos] == '-' && next_expected_positive)) {
					if (pos > 2) {
						sb.delete(sb.length() - 3, sb.length());
						sb.append("0000");
						next_expected_positive = (bc[pos] == '-');
						App.dbg("Violation, rewriting...");

					} else {
						System.out.println("EARLY VIOLATION");
						sb.append('?');
					}
				} else if (bc[pos] == '+' || bc[pos] == '-') {
					sb.append('1');
					App.dbg("Append 1.");
					next_expected_positive = (bc[pos] == '-');
				} else {
					sb.append('0');
					App.dbg("Append 0.");
				}

				pos++;
				App.dbg("Input string:  " + s);
				App.dbg("Output string: " + sb.toString());

				// Exit loop.
				if (pos >= bc.length)
					break;
			}
		}

		App.dbg("Final Input string:  " + s);
		App.dbg("Final Output string: " + sb.toString());

		String res = sb.toString();
		System.out.println("HDB3 -> Binary :  " + res);
		return res;
	}

	public static String encode(String s) {
		App.dbg("\n\n[dbg] Converting string to HDB3.");
		App.dbg("First converting to binary string...");
		return binaryHDB3encode(Binary.encode(s));
	}

	public static String decode(String s) {
		App.dbg("\n\n[dbg] Decoding HDB3 string.");
		return Binary.decode(binaryHDB3decode(s));
	}
}
