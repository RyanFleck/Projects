import java.util.ArrayList;
import java.lang.StringBuilder;

class PatternPrinter {
    public static void main(String[] args) {
        System.out.println("Pattern Printer V1.\nGenerating...");
        patternOne();
        patternTwo();
        patternThree();
        patternFour();
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
        gap();
        return pattern;
    }
    public static ArrayList<String> patternTwo() {
        ArrayList<String> pattern = new ArrayList<String>();

        for(int i=1; i<=9; i++) {
            if(i==1 || i==5 || i==9) {
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
        gap();
        return pattern;
    }

    public static ArrayList<String> patternThree() {
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
                    if( j%3 == 0 ) {
                        s.append("x");
                    } else {
                        s.append(".");
                    }
                }
                s.append(Integer.toString(i));
                for(int j=1; j<=8; j++) {
                    if( j%3 == 0 ) {
                        s.append("x");
                    } else {
                        s.append(".");
                    }
                }
                s.append(Integer.toString(i));
                System.out.println(s.toString());
            }
        }
        gap();
        return pattern;
    }

    public static ArrayList<String> patternFour() {
        ArrayList<String> pattern = new ArrayList<String>();
        int instances = 0;

        for(int i=1; i<=9; i++) {
            int dotnum = 9 - i;
            StringBuilder s = new StringBuilder();
            s.append(repeatString(".",dotnum));
            s.append(repeatString(Integer.toString(i),instances));
            s.append(repeatString(".",dotnum));
            System.out.println(s.toString());
            instances += 2;
        }
        gap();
        return pattern;
    }

    public static void gap() {
        System.out.println("");
    }

    public static String repeatString(String x, int n) {
        return new String(new char[n]).replace("",x);
    }
}
