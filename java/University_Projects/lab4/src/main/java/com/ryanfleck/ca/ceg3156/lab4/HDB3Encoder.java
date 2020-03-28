package com.ryanfleck.ca.ceg3156.lab4;

public class HDB3Encoder {

    public static String encode(String message) {
        String hdb3stream = message;

        int index0;
        index0 = hdb3stream.indexOf("0000");
        int index1 = 0;

        while (index0 != -1) {
            if ((index0 - index1) % 2 == 1)
                hdb3stream = hdb3stream.substring(0, index0) + "000V"
                        + hdb3stream.substring(index0 + 4);
            else
                hdb3stream = hdb3stream.substring(0, index0) + "B00V"
                        + hdb3stream.substring(index0 + 4);

            index1 = index0 + 4;

            index0 = hdb3stream.indexOf("0000");
        }

        int signal = 0;

        char last1bit = '0';
        char lastbit = '0';

        for (int pos = 0; pos < message.length(); pos++) {
            if (hdb3stream.charAt(pos) == '1') {
                if (signal % 2 == 0) {
                    last1bit = '+';
                } else {
                    last1bit = '-';
                }

                lastbit = last1bit;
                hdb3stream = hdb3stream.substring(0, pos) + lastbit
                        + hdb3stream.substring(pos + 1);
                signal++;
            } else if (hdb3stream.charAt(pos) == 'V') {
                hdb3stream = hdb3stream.substring(0, pos) + lastbit
                        + hdb3stream.substring(pos + 1);
            } else if (hdb3stream.charAt(pos) == 'B') {
                if (last1bit == '+')
                    lastbit = '-';
                else
                    lastbit = '+';
                signal++;
                hdb3stream = hdb3stream.substring(0, pos) + lastbit
                        + hdb3stream.substring(pos + 1);
            }
        }
        return hdb3stream;
    }

    public static String decode(String data) {

        String message = data;

        char lastpo1 = '0';
        char tempc = '0';

        for (int pos = 0; pos < message.length(); pos++) {
            if (message.charAt(pos) != '0') {
                tempc = message.charAt(pos);

                if (lastpo1 == message.charAt(pos)) {
                    message = message.substring(0, pos - 3) + "0000"
                            + message.substring(pos + 1);
                }
                lastpo1 = tempc;
            }
        }

        for (int pos = 0; pos < message.length(); pos++) {
            if (message.charAt(pos) != '0') {
                message = message.substring(0, pos) + '1'
                        + message.substring(pos + 1);
            }
        }
        return message;
    }

}
