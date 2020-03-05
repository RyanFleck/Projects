import java.util.ArrayList;
import java.lang.StringBuilder;

class PatternPrinter {
    public static void main(String[] args) {
        System.out.println("Pattern Printer V1.\nGenerating...");
        patternOne();
    }

    public static ArrayList<String> patternOne() {
        ArrayList<String> pattern = new ArrayList<String>();

        for(int i=1; i<=9; i++) {
            if(i==1 || i==9) {
                String line;
                line = repeatString(Integer.toString(i), 18);
                System.out.println(line);
            } else {
                StringBuilder s = new StringBuilder();
                s.append(Integer.toString(i));
                for(int j=1; j<=8; j++) {
                    s.append(".");
                }
                s.append(Integer.toString(i));
                for(int j=1; j<=8; j++) {
                    s.append(".");
                }
                s.append(Integer.toString(i));
                System.out.println(s.toString());
            }
        }
        return pattern;
    }

    public static String repeatString(String x, int n) {
        return new String(new char[n]).replace("",x);
    }
}
