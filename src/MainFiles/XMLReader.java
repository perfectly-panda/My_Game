package MainFiles;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
	
	public static void main(String[] args){
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
			try {
				Document document = dBuilder.parse(XMLReader.class.getResourceAsStream("Resources/xmls/map1.xml"));
				document.normalize();
				
				NodeList rootNodes = document.getElementsByTagName("tiles");
				Node rootNode = rootNodes.item(0);
				Element rootElement = (Element) rootNode;
				
				NodeList rowsList = rootElement.getElementsByTagName("row");
				for(int i = 0; i < rowsList.getLength(); i++){
					Node theRow = rowsList.item(i);
					NodeList tilesList = rootElement.getElementsByTagName("tile");
					for(int n = 0; n < tilesList.getLength(); n++){
						Node theTile = tilesList.item(n);
						Element tileElement = (Element) theTile;
					}
				}
			
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
	}

}
