

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLFile {

  public static void main(String argv[]) {

    try {

	File fXmlFile = new File("D:\\test.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("Row");
	Node nHeader = nList.item(0);
	Node nValues = nList.item(1);
	List<String> lHeader = new ArrayList<String>();
	List<String> lValues = new ArrayList<String>();
	Element eHeader = (Element) nHeader;
	Element eValues = (Element) nValues;
	NodeList dHeader = eHeader.getElementsByTagName("Data");
	NodeList dValues = eValues.getElementsByTagName("Data");
	for (int temp = 0; temp < dHeader.getLength(); temp++) {
		Element eElement = (Element) dHeader.item(temp);
		lHeader.add(eElement.getTextContent());
		System.out.println("Staff id : " + eElement.getTextContent());
		
	}
	for (int temp = 0; temp < dValues.getLength(); temp++) {
		Element eElement = (Element) dValues.item(temp);
		lValues.add(eElement.getTextContent());
		System.out.println("Staff id : " + eElement.getTextContent());
		
	}
	
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}