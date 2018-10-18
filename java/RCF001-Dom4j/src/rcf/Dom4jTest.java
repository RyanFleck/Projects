/**
 * @author Ryan.Fleck
 * @version 1.0.3 2018-10-17
 * 
 * FooBar is a test class for testing the Dom4j library.
 */
package rcf;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import rcf.utils.Doc;
import rcf.utils.IO;

/**
 * @since 1,0.0
 * @author Ryan.Fleck
 * 
 *         This is a test-class for tinkering with Dom4j.
 * 
 *         Requires dom4j and jaxen .jar files.
 */
public class Dom4jTest {

	/**
	 * This PSVM runs through the following concepts from the Dom4j page:
	 * 
	 * 1 - Parsing XML from a file.
	 * 
	 * 2 - Iterating through elements in a document.
	 * 
	 * 3 - Applying XPath expressions to select nodes.
	 * 
	 * 4 - Fast looping method for large documents.
	 * 
	 * 5 - Creating/writing XML documents to file system.
	 * 
	 * @param args
	 *            Canonical input-stream processing variable.
	 */
	public static void main(String[] args) {
		System.out.println("Dom4j XML-Processing Experiment.");

		// 1 - Parsing XML from a file.

		// Initialize SAXReader built into Dom4j:
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read("data/oct-en.xml");
			System.out.println("Document read to var 'd'.");
		} catch (DocumentException de) {
			System.out.println("Document read error.\n" + de.toString());
			System.exit(0);
		}

		// 2 - Iterating through elements in a document.

		// Iterate through the document.
		Element root = doc.getRootElement();
		recursiveWalkDOM(root);

		// 3 - Applying XPath expressions to select nodes.

		Doc.info(root);

		// List<Node> items = doc.selectNodes("//rss/channel/item");
		// System.out.println(items.toString());
		Node n = doc.selectSingleNode("//rss/channel/item");
		System.out.format("%nValue%s %s%n", ":", n.valueOf("title")); // Why won't this work? [UPDATE: Without '@'
																		// works] // fine. Strange.]
		System.out.format("Node name: %s%n", n.getName()); // Correct node DOES appear to be selected.
		// [ECLIPSE] Java/editor/content assist/advanced => Proposals crashed? Enable
		// when network available.

		List<Node> nl = doc.selectNodes("//rss/channel/item");
		System.out.format("Found %s items in the RSS feed: ", nl.toArray().length);
		nl.forEach((nli) -> {
			System.out.format("%s ", nli.getName());
		});
		nl.forEach((nli) -> {
			System.out.format("%n%s => %s ", nli.valueOf("pubDate"), nli.valueOf("title"));
		});
		System.out.print("\n");

		// Prove I can write utilities.
		IO.prove();
		Doc.prove();
		
		// Wow! ConcurrentHashMaps are a thing:
		// ConcurrentHashMap<String,List<String>> chm = new ConcurrentHashMap<>();
		// chm.put("Burger", Arrays.asList("Lettuce","Bun","Tomato","Patty","Cheese"));
		// chm.put("Salad", Arrays.asList("Lettuce","Tomato","Cucubmer","Carrots","Dressing"));
		
		// 4 - Fast Looping Method.
	}

	/**
	 * @param documentRoot
	 *            Root Element of XML document as read by a SAXReader.
	 */
	public static void recursiveWalkDOM(Element documentRoot) {
		System.out.println("\nRecursively walk DOM for " + documentRoot.getName() + ", printing out tags:\n");
		recursiveStep(documentRoot, 0);
	}

	/**
	 * Recursively iterates through XML elements.
	 */
	private static void recursiveStep(Element x, int depth) {
		System.out.println(rep(depth, "  ") + x.getName() + ": " + Doc.trimString(x.getTextTrim(), 30));
		for (Iterator<Element> it = x.elementIterator(); it.hasNext();) {
			Element element = it.next();
			recursiveStep(element, depth + 1);
		}
	}

	/**
	 * Repeats a string a specified number of times.
	 * 
	 * @param c
	 *            Number of repetitions.
	 * @param s
	 *            String to repeat.
	 */
	private static String rep(int c, String s) {
		StringBuilder repeated = new StringBuilder(c);
		for (int i = 0; i < c; i++) {
			repeated.append(s);
		}
		return repeated.toString();
	}

	/**
	 * Prints the name, children array and short content of an XML node.
	 */
	/*private static void printFullElementInfo(Element x) {

		String name;
		String content;
		String children;

		ArrayList<String> childArray = new ArrayList<>();

		name = x.getName();

		content = Doc.trimString(x.getTextTrim(), 40);
		if (content.equals("")) {
			content = "No content.";
		}

		for (Iterator<Element> it = x.elementIterator(); it.hasNext();) {
			Element element = it.next();
			childArray.add(element.getName());
		}

		children = childArray.toString();

		System.out.format("%nName: %s%nContent: %s%nChildren: %s%n", name, content, children);
	}*/

}
