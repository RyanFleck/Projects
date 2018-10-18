package rcf.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * Utility for loading and saving XML files.
 */
public class IO {

	/**
	 * Private constructor so utility class can't be instantiated.
	 */
	private IO() {
	}

	public static Document read(String file) {
	    SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(file);
			return doc;
		} catch (DocumentException de) {
			return null;
		}
    }

	/**
	 * 
	 */
	public static void prove() {
		System.out.println("IO Class properly imported!");
	}
}
