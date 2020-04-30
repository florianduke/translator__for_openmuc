package de.isc.konstanz.aml;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AASReader {

	public static int channelNumber = 1;
public static  int nestingLevel = 0;
public static int j = 0;
	
	public static void main(File selectedFile){
		// SAXBuilder builder = new SAXBuilder();
//		  File xmlFile = new File("C:\\Users\\fhe\\Desktop\\rena_stable2.xml");
	   
		
		  try {
			  Channel channel = new Channel();
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser = factory.newSAXParser();

				DefaultHandler handler = new DefaultHandler() {

				boolean bnname = false;
				boolean bsalary = false;

				public void startElement(String uri, String localName,String qName, 
			                Attributes attributes) throws SAXException {
//					channelNumber++;
				    nestingLevel++;
//					System.out.println("Start Element :" + qName + ", Level "+nestingLevel);


					if (qName.equalsIgnoreCase("aas:idShort")) {
						bnname = true;
					}

					if (qName.equalsIgnoreCase("aas:value")) {
						bsalary = true;
					}
					
					if (qName.equalsIgnoreCase("aas:value")) {
						bsalary = true;
					}
				

//					for(int i = 0; i < nestingLevel*2; i++)
////				        System.out.print(' ');
////				      System.out.println(qName);
//				      // ...und die Schachtelungstiefe hochzählen
				  
				}

				public void endElement(String uri, String localName,
					String qName) throws SAXException {

//					System.out.println("End Element :" + qName);
					 nestingLevel--;

				}

				public void characters(char ch[], int start, int length) throws SAXException {

					
					if (bnname) {
						System.out.println("Level "+nestingLevel+", Source : " + new String(ch, start, length));
						String name = new String(ch, start, length);
					
						if(nestingLevel==7 && name.equals("PostgreSQL")) {
							j = 1;
						}
						if(nestingLevel==10 && j==1 && !name.contains(" ")) {
							if(Character.isUpperCase(name.charAt(0))) {
							System.out.println("Subfolder: "+name);
							channel.subFolder.add(name);
							}
							if(Character.isLowerCase(name.charAt(0))) {
							System.out.println("Folder: "+name);
							channel.folder.add(name);
							}
						}
						if(nestingLevel==13 && j==1/* && !name.contains("")*/) {
							System.out.println("Channelname: "+name);
							channel.name.add(name);
						}
				
						bnname = false;
					}

					if (bsalary) {
						System.out.println("Level "+nestingLevel+", Value : " + new String(ch, start, length));
						String value =  new String(ch, start, length);
						if(nestingLevel==10 && j==1 && !value.substring(0).contains(" ")) {
							System.out.println("Device Adress: " + value);
							channel.adress.add(value);
						}
						if(nestingLevel==13 && j==1 && !value.substring(0).contains(" ")) {
							System.out.println("Channel Adress: " + value);
							channel.key.add(value.split(";", 2)[0]);
							channel.keyColumn.add(value.split(";",2)[1]);				
							System.out.println("Key: "+channel.key.get(channelNumber-1));
							System.out.println("Column: "+channel.keyColumn.get(channelNumber-1));
							channelNumber++;
						}
						bsalary = false;
					}

				}

			     };

			       saxParser.parse(selectedFile, handler);
			       ChannelWriter.main(channel);
			     } catch (Exception e) {
			       e.printStackTrace();
			     }
			  
			   }
	
	
}