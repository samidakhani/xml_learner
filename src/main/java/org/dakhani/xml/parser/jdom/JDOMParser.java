package org.dakhani.xml.parser.jdom;

import java.io.InputStream;
import java.util.List;

import org.dakhani.utils.ResourceLoader;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * @author Sami Dakhani Created on Nov 27, 2016
 *
 */
public class JDOMParser {

	public static final String XML_FILE = "staff.xml";

	public static void main(final String[] args) {

		try {

			ResourceLoader rLoader = new ResourceLoader();
			InputStream is = rLoader.loadResource(XML_FILE);

			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(is);
			Element rootNode = document.getRootElement();

			List list = rootNode.getChildren("staff");
			for (int i = 0; i < list.size(); i++) {

				Element element = (Element) list.get(i);
				System.out.println(
						"Firstname: " + element.getChildText("firstname"));
			}

		} catch (Exception e) {
		}
	}
}
