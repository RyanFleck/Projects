import java.io.Console;

class cli{

public static void main(String[] args){
    System.out.println("Hello, World!");
    Console console = System.console();
    String docname = console.readLine("New document name: ");
    String dockey = new String(console.readPassword("New document password: "));
    System.out.println("Creating "+docname+"...");
}

}

// https://dzone.com/articles/interactive-console-applications-in-java
