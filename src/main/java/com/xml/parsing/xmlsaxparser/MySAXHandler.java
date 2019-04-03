package com.xml.parsing.xmlsaxparser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Kavya Kommineni
 * This class extends the DefaultHandler which provides methods to parse the content of the XML file
 */
public class MySAXHandler extends DefaultHandler {
	String data = null;

	List<Contact> contactList = new ArrayList<Contact>();
	Contact contact = new Contact();
	
	/**
	 * This method is called when the start tag in the XML is encountered. It checks
	 * and gets the attribute from the tag and sets the tags true as they are encountered.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if (qName.equalsIgnoreCase("contact")) 
		{
			try {
			contact.setId(Integer.parseInt(attributes.getValue("id")));
			}catch(NumberFormatException e) {
				System.out.println("Number Format Exception while trying to converting String to integer");
			}
			catch(Exception e)
			{
				System.out.println("Exception occurred : " + e.getCause());
			}
		}
	}

	/**
	 * This method is called when the end tag in the XML is encountered. It checks
	 * for the end tag and then adds the contact to the list.
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("name")) {
			contact.setName(data);
		}
		else if (qName.equalsIgnoreCase("lastName")) {
			contact.setLastName(data);
			contactList.add(new Contact(contact.getId(), contact.getName(), contact.getLastName()));
		}
	}

	/**
	 * This method is called when the data of the tags in the XML is encountered. It
	 * checks the tags for the names and then saves into the corresponding fields
	 * and sets the tags to false.
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
			data = new String(ch, start, length);
			
	}
	
	/**
	 * This method is called when the end of the root tag in the XML is encountered.
	 * It then prints all the elements of the contact list that are in the XML
	 */
	@Override
	public void endDocument() throws SAXException {
		contactList.stream().forEach(System.out::println);
	}
}