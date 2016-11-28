package org.dakhani.xml.parser.dom;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dakhani.utils.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Sami Dakhani Created on Nov 27, 2016
 *
 */
public class DOMParserSimple {

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

			System.out.println("Root Elemnet: "
					+ document.getDocumentElement().getNodeName());

			if (document.hasChildNodes()) {
				printNode(document.getChildNodes());
			}

		} catch (Exception e) {

		}

	}

	private static void printNode(final NodeList nodeList) {

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node element = nodeList.item(i);

			if (element.getNodeType() == Node.ELEMENT_NODE) {

				System.out.println(
						"\nNode Name =" + element.getNodeName() + " [OPEN]");
				System.out.println("Node-value: " + element.getTextContent());

				NamedNodeMap attributeMap = element.getAttributes();
				for (int j = 0; j < attributeMap.getLength(); j++) {

					Node atribute = attributeMap.item(j);
					System.out.println(
							"Atribute Name: " + atribute.getNodeName());
					System.out.println(
							"Atribute Value: " + atribute.getNodeValue());
				}

				if (element.hasChildNodes()) {
					printNode(element.getChildNodes());
				}

				System.out.println(
						"Node Name =" + element.getNodeName() + " [CLOSE]");

			}
		}
	}
}
