package rcf.utils;

import org.dom4j.Element;
import java.util.ArrayList;
import java.util.Iterator;
import org.dom4j.Document;

/**
 * Utility for extracting information from XML files.
 */
public class Doc {

	/**
	 * Private constructor so utility class can't be instantiated.
	 */
	private Doc() {
	}

	public static Element root(Document doc) {
		return doc.getRootElement();
	}

	public static void info(Document doc) {
		info(root(doc));
	}

	public static void info(Element x) {
		String name;
		String content;
		String children;

		ArrayList<String> childArray = new ArrayList<>();

		name = x.getName();

		content = trimString(x.getTextTrim(), 40);
		if (content.equals("")) {
			content = "No content.";
		}

		for (Iterator<Element> it = x.elementIterator(); it.hasNext();) {
			Element element = it.next();
			childArray.add(element.getName());
		}

		children = childArray.toString();

		System.out.format("%nName: %s%nContent: %s%nChildren: %s%n", name, content, children);
	}

	/**
	 * If a string is over a character length, trim and add an ellipsis.
	 */
	public static String trimString(String s, int length) {
		if (s.length() > length) {
			return s.substring(0, (length - 3)).concat("...");
		} else {
			return s;
		}
	}

	/**
	 * 
	 */
	public static void prove() {
		System.out.println("Doc Class properly imported!");
	}
}
