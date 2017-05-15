import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlayHistory {
    private String fileName;
    private FileWriter writeToLog;
    private BufferedWriter bufferedWrite;
    private File history;
    private final String name = "UNTITLED LOGGING RPG";
    private final Prompt prompt;

    /*
     * public static void main(String[] args) {
     * System.out.println("Testing FILE I/O"); final PlayHistory testHistory =
     * new PlayHistory("Testing"); // testHistory.log("Event one."); //
     * testHistory.log("Event two."); // testHistory.log("Event three.");
     * testHistory.end(); }
     */

    public PlayHistory(String playerName) {
	/*
	 * This class logs the actions of the player into a text file, so the
	 * player can share their journey with the world!
	 */
	prompt = new Prompt();
	fileName = playerName.concat(".txt").toLowerCase();
	System.out.println("Saving to " + fileName);

	try {

	    System.out.println("Writing file...");

	    // Check for presence of file in filesystem and ask to
	    // overwrite or
	    // change name.
	    history = new File(fileName);
	    if (history.exists()) {
		if (prompt.askBool("File already exists! Overwrite file?")) {
		    System.out.println("Overwriting...");
		} else {
		    while (new File(fileName).exists()) {
			fileName = prompt.askString("Enter a new filename.")
				.concat(".txt").toLowerCase();
		    }
		}
	    }

	    writeToLog = new FileWriter(fileName);
	    bufferedWrite = new BufferedWriter(writeToLog);

	    bufferedWrite.write(name);
	    System.out.print(name);
	    appendLog(" 0.0.2");
	    log("Filename: " + fileName);

	} catch (final IOException e) {
	    e.printStackTrace();
	}

    }

    public void log(String event) {
	System.out.print("\n" + event);
	try {
	    bufferedWrite.newLine();
	    bufferedWrite.write(event);
	} catch (final IOException e) {
	    System.out.println("Log Event Failure.");
	    e.printStackTrace();
	}

    }

    public void appendLog(String event) {
	System.out.print(event);
	try {
	    bufferedWrite.write(event);
	} catch (final IOException e) {
	    System.out.println("Log Event Failure.");
	    e.printStackTrace();
	}
    }

    public void read() {
    }

    public void end() {
	try {
	    bufferedWrite.close();
	    writeToLog.close();
	    System.out.println("\n\nFIN");
	} catch (final IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
