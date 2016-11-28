package org.dakhani.xml.parser.sax;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dakhani.utils.ResourceLoader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Sami Dakhani Created on Nov 27, 2016
 *
 */
public class SAXDocParser {

	public static final String XML_FILE = "staff.xml";

	public static void main(final String[] args) {

		try {

			ResourceLoader rLoader = new ResourceLoader();
			InputStream is = rLoader.loadResource(XML_FILE);

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean bfname = false;
				boolean blname = false;
				boolean bnname = false;
				boolean bsalary = false;

				@Override
				public void characters(final char ch[], final int start,
						final int length) throws SAXException {

					if (this.bfname) {
						System.out.println(
								"Firstname: " + new String(ch, start, length));
						this.bfname = false;
					}

					if (this.blname) {
						System.out.println(
								"Last Name : " + new String(ch, start, length));
						this.blname = false;
					}

					if (this.bnname) {
						System.out.println(
								"Nick Name : " + new String(ch, start, length));
						this.bnname = false;
					}

					if (this.bsalary) {
						System.out.println(
								"Salary : " + new String(ch, start, length));
						this.bsalary = false;
					}

				}

				@Override
				public void endElement(final String uri, final String localName,
						final String qName) throws SAXException {
					System.out.println("End Element :" + qName);
				}

				@Override
				public void startElement(final String uri,
						final String localName, final String qName,
						final Attributes attributes) throws SAXException {

					System.out.println("Start Element :" + qName);

					if (qName.equalsIgnoreCase("firstname")) {
						this.bfname = true;
					}

					if (qName.equalsIgnoreCase("lastname")) {
						this.blname = true;
					}

					if (qName.equalsIgnoreCase("nickname")) {
						this.bnname = true;
					}

					if (qName.equalsIgnoreCase("salary")) {
						this.bsalary = true;
					}
				}

			};

			saxParser.parse(is, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
