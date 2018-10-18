package rcf.utils;

import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

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
	
	public static void write(Document doc, String filename) {
		
		try {
			FileWriter fw = new FileWriter(filename);
			XMLWriter xw = new XMLWriter(fw);
			xw.write(doc);
			xw.close();
			fw.close();
			
		}catch(Exception e) {
			System.out.println("IO Error: "+e.toString());
		}
	}

	/**
	 * 
	 */
	public static void prove() {
		System.out.println("IO Class properly imported!");
	}
}
