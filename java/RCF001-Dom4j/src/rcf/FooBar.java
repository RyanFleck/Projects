/**
 * @author Ryan.Fleck
 * @version 1.0.3 2018-10-17
 * 
 * FooBar is a test class for testing the Dom4j library.
 */
package rcf;

import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;


/**
 * @since 1,0.0
 * @author Ryan.Fleck
 * 
 * FooBar is a test-class for tinkering with Dom4j.
 */
public class FooBar {

    /**
     * This PSVM runs through the following concepts from the Dom4j page:
     *  1 - Parsing XML from a file.
     *  2 - Iterating through elements in a document.
     *  3 - Applying XPath expressions to select nodes.
     *  4 - Fast looping method for large documents.
     *  5 - Creating/writing XML documents to file system.
     * 
     * @param args Canonical input-stream processing variable.
     */
    public static void main(String[] args) {
        System.out.println("Dom4j XML-Processing Experiment.");
        
        // Initialize SAXReader built into Dom4j:
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read("data/oct-en.xml");
            System.out.println("Document read to var 'd'.");
        } catch (DocumentException de) {
            System.out.println("Document read error.\n"+de.toString());
            System.exit(0);
        }
        
        // Iterate through the document.
        Element root = doc.getRootElement();
        recursiveWalkDOM(root);
    
        /*
         * At this point in the program, output appears as follows:
         * 
         * Dom4j XML-Processing Experiment.
         * Document read to var 'd'.
         * Recursively walk DOM for rss, printing out tags.
         * rss: 
         *   channel: 
         *     title: OC Transpo - Live Updates
         *     link: http://www.octranspo.com/
         *     description: Daily route changes resulting ...
         *     link: 
         *     item: 
         *       title: Queensway Station: Elevator
         *       pubDate: Wed, 17 Oct 2018 07:08:00 EDT
         *       category: General Message
         *       category: affectedRoutes-
         *       link: http://octranspo1.com/update-d...
         *       description: October 17 2018 - <p><strong>Q...
         *       guid: http://octranspo1.com/update-d...
         */
        
        
    }
    
    /**
     * @param documentRoot Root Element of XML document as read by a SAXReader.
     */
    public static void recursiveWalkDOM(Element documentRoot ) {
        System.out.println("Recursively walk DOM for "+documentRoot.getName()+", printing out tags.");
        recursiveStep(documentRoot,0);
    }
    
    private static void recursiveStep(Element x, int depth) {
        System.out.println(rep(depth,"  ")+x.getName()+": "+rTrimString(x.getTextTrim(),30));
        for (Iterator<Element> it = x.elementIterator(); it.hasNext();) {
            Element element = it.next();
            recursiveStep(element, depth+1);
        }
    }
    
    private static String rep(int c, String s) {
        StringBuilder repeated = new StringBuilder(c);
        for(int i=0; i<c; i++) {
            repeated.append(s);
        }
        return repeated.toString();
    }
    
    private static String rTrimString( String s, int length) {
        if(s.length() > length) {
            return s.substring(0,length).concat("...");
        } else {
            return s;
        }
    }


}
