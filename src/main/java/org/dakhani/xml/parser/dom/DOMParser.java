package org.dakhani.xml.parser.dom;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dakhani.utils.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Sami Dakhani Created on Nov 27, 2016
 *
 */
public class DOMParser {

	public static final String XML_FILE = "staff.xml";

	public static void main(final String[] args) {

		try {

			ResourceLoader rLoader = new ResourceLoader();
			InputStream is = rLoader.loadResource(XML_FILE);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document document = dBuilder.parse(is);
			document.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ document.getDocumentElement().getNodeName());

			NodeList staffList = document.getElementsByTagName("staff");
			for (int i = 0; i < staffList.getLength(); i++) {

				Node staffNode = staffList.item(i);
				if (staffNode.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) staffNode;
					System.out
							.println("Staff Id: " + element.getAttribute("id"));
					System.out.println("Firstname: "
							+ element.getElementsByTagName("firstname").item(0)
									.getTextContent());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
