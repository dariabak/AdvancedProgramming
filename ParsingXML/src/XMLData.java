import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.*;

public class XMLData {
	public static void main(String[]args) {
		
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = db.parse("./library.xml");
			
			Element root = document.getDocumentElement();
			NodeList titleNodes = root.getElementsByTagName("title");
			
			for(int i = 0; i < titleNodes.getLength(); i++) {
				if(titleNodes.item(i).getChildNodes().item(0).getNodeValue().equals("XML in a Nutshell")){
					Node book = titleNodes.item(i).getParentNode();
					System.out.println(titleNodes.item(i).getChildNodes().item(0).getNodeValue());
					NodeList children = book.getChildNodes();
					for(int j = 0; j < children.getLength(); j++) {
						Node c = children.item(j);
						if(c.getNodeName().equals("authors")) {
							NodeList grandchildren = c.getChildNodes();
							for(int k = 0; k < grandchildren.getLength(); k++) {
								Node a = grandchildren.item(k);
								if(a.getNodeName().equals("author")) {
									NodeList names = a.getChildNodes();
									for(int t = 0; t < names.getLength(); t++) {
										Node n = names.item(t);
										if(n.getNodeName().equals("forename")) {
											System.out.println(n.getChildNodes().item(0).getNodeValue());
										} else if(n.getNodeName().equals("surname")) {
											System.out.println("Author: " + n.getChildNodes().item(0).getNodeValue());
										}
									}
								}
							}
						}
					}
				}
			}
			
			
		} catch(ParserConfigurationException | SAXException | IOException e) {
			System.err.println("Error opening XML file: " + e);
		}
	}
}
	