import java.io.IOException;
import java.util.Scanner;

public class Prompt {
    private String inputTxt = null;
    private final Scanner input;

    public Prompt() {
	input = new Scanner(System.in);
    }

    public boolean askBool(String question) {
	System.out.print(question + "\n(Answer with yes/no) >>> ");
	inputTxt = input.next();
	final String booleanVal = inputTxt.substring(0, 1).toLowerCase();
	System.out.println("Recorded value is:" + booleanVal);
	if (booleanVal.equals("y")) {
	    System.out.println("Selected Y.");
	    return true;
	}
	System.out.println("Selected N.");
	return false;

    }

    public String askString(String question) {
	System.out.println(question + "\n(Type your answer.) >>> ");
	String toReturn = input.next();
	input.nextLine() ;
	//System.out.println("RETURNING "+toReturn);
	return toReturn;
    }

    public String askLongString(String question) {
	System.out.println(question + "\n(Type your answer.) >>> ");
	final String testingString = input.nextLine();
	// while(input.hasNext()){testingString.concat(input.next());}
	return testingString;
    }
    
    public String askChoice(String question,String[] options) {
	
	System.out.print(question);
	int x;
	int ans=0;
	for(x=0;x<options.length;x++){System.out.print("\n -"+options[x]);}
	System.out.println("\n(Type your answer.) >>> ");
	final String testingString = input.nextLine();
	
	for(x = 0;x<options.length;x++)
	{
	    if(options[x].toLowerCase().charAt(0)==testingString.toLowerCase().charAt(0))
	    {System.out.println("Option chosen: "+options[x]);
	    ans=x;}
	}
	return options[ans].toLowerCase();
    }

    public void petc() {
	try {
	    System.out.print("\nPress ENTER to continue.");
	    System.in.read();
	} catch (final IOException e) {
	} // Press ENTER to continue.
    }
}
