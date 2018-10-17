/**
 * @author Ryan.Fleck
 * @version 1.0.0 2018-10-17
 * 
 * FooBar is a test class for testing the Dom4j library.
 */
package rcf;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;


/**
 * 
 */
public class FooBar {

    /**
     * This PSVM runs through the following concepts from the Dom4j page:
     *  - Parsing XML from a file.
     *  - Iterating through elements in a document.
     *  - Applying XPath expressions to select nodes.
     *  - Fast looping method for large documents.
     *  - Creating/writing XML documents to file system.
     * 
     * @param args Canonical input-stream processing variable.
     */
    public static void main(String[] args) {
        System.out.println("Dom4j XML-Processing Experiment.");
        
        // Initialize SAXReader built into Dom4j:
        SAXReader r = new SAXReader();
        Document d = null;
        try {
            d = r.read("data/oct-en.xml");
            System.out.println("Document read to var 'd'.");
        } catch (DocumentException e) {
            System.out.println("Document read error.\n"+e.toString());
            System.exit(0);
        }
        
        // Inspect the document and pull data?
        Element docRoot = d.getRootElement();
    }

}
