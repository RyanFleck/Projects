import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            // Complete this line
            System.out.println(s1.concat(spaces(15 - s1.length())).concat(paddedIntString(x)));
        }
        System.out.println("================================");

    }

    private static String spaces(int numberOfSpaces) {
        StringBuilder sb = new StringBuilder("");
        for (int x = 0; x < numberOfSpaces; x++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String paddedIntString(int a) {
        String intStr = Integer.toString(a);
        while (intStr.length() < 3) {
            intStr = "0" + intStr;
        }
        return intStr;
    }
}
