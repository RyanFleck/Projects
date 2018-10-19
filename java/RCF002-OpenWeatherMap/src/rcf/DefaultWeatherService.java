/**
 * 
 */
package rcf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Ryan Fleck
 * 
 *         External Content Service is assumed/emulated.
 * 
 *         IMPORTANT NOTE: config-default.xml must be copied to default.xml and populated with an OWM API key before use.
 *
 */
public class DefaultWeatherService implements WeatherService {

    private String requestURL;
    private List<String> defaultParams = new ArrayList<>();
    private String gwError = "\nWARNING: Ensure you have copied config-default.xml to default.xml and provided an API key.\n";

    /**
     * 
     */
    public DefaultWeatherService() {

        /*
         * Reads configs from an XML file. Saves all query params into defaultParams, and base URL into requestURL.
         */

        SAXReader reader = new SAXReader();
        try {

            Document doc = reader.read("data/config.xml");

            doc.selectNodes("//configuration/parameters/item").forEach((n) -> {
                defaultParams.add(n.getStringValue().trim());
            });

            requestURL = doc.selectSingleNode("//configuration/apilink").getStringValue().trim();

        } catch (DocumentException de) {
            dbg("Config could not be read.");
        }
    }

    /*
     * Important that items like this are _static_ so they can only be called by an instantiated object.
     */

    @Override
    public Document getWeather(String cityName) throws WeatherException {

        List<String> requestParams = new ArrayList<>();
        defaultParams.forEach(requestParams::add); // Replaced lambda with a method reference.
        requestParams.add("q=" + cityName.trim());
        String request = requestURL + consolidateParams(requestParams);

        dbg("Sending request: " + request);

        SAXReader reader = new SAXReader();
        try {

            /*
             * Fetch XML and walk through +print the DOM to ensure the data was actually fetched:
             */
            Document doc = reader.read(new URL(request).openStream());
            //recursiveWalkDOM(doc.getRootElement()); //If enabled, prints a key/value tree of the fetched XML doc.
            if (doc.getRootElement().getName().equalsIgnoreCase("current")) {
                return doc;
            } else {
                throw new MalformedURLException("City name malformed.");
            }

        } catch (DocumentException de) {
            dbg(gwError + "Config could not be read. Error: " + de.toString());
        } catch (MalformedURLException mue) {
            dbg(gwError + "URL is malformed.. Error: " + mue.toString());
        } catch (IOException ioe) {
            String ioError = "WARNING: Arguments may be malformed, or API key invalid.\n";
            dbg(gwError + ioError + "I/O Exception. Error: " + ioe.toString());
        }

        return null;

    }

    private static String consolidateParams(List<String> p) {
        if (!p.isEmpty()) {
            StringBuilder params = new StringBuilder();
            ListIterator<String> i = p.listIterator();

            params.append("?");
            params.append(i.next());

            while (i.hasNext()) {
                params.append("&" + i.next());
            }

            return params.toString();

        } else {
            return "";
        }
    }

    /*
     * RCF - Debugging and data visualization methods. Methods below not required for functional implementation.
     */
    private static void dbg(Object s) {
        try {
            System.out.println("[DefaultWeatherService] " + s.toString());
        } catch (Exception e) {
            System.out.println("[DefaultWeatherService] No toString() for Object. Error: " + e.toString());
        }
    }

    @SuppressWarnings("unused")
    private static void recursiveWalkDOM(Element documentRoot) {
        System.out.println("\nRecursively walk DOM for " + documentRoot.getName() + ", printing out tags:\n");
        recursiveStep(documentRoot, 0);
    }

    private static void recursiveStep(Element x, int depth) {
        System.out.println(rep(depth, "  ") + x.getName() + ": " + x.getTextTrim());
        for (Iterator<Element> it = x.elementIterator(); it.hasNext();) {
            Element element = it.next();
            recursiveStep(element, depth + 1);
        }
    }

    private static String rep(int c, String s) {
        StringBuilder repeated = new StringBuilder(c);
        for (int i = 0; i < c; i++) {
            repeated.append(s);
        }
        return repeated.toString();
    }
}
