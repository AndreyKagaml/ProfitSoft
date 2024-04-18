package generate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Map;
public class XmlGenerator {
    public void generateXml(Map<String, Integer> statistics, String attributeName) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("statistics");
            doc.appendChild(rootElement);

            for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
                Element itemElement = doc.createElement("item");
                rootElement.appendChild(itemElement);

                Element valueElement = doc.createElement("value");
                Text valueText = doc.createTextNode(entry.getKey());
                valueElement.appendChild(valueText);
                itemElement.appendChild(valueElement);

                Element countElement = doc.createElement("count");
                Text countText = doc.createTextNode(String.valueOf(entry.getValue()));
                countElement.appendChild(countText);
                itemElement.appendChild(countElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("statistics_by_" + attributeName + ".xml");
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
