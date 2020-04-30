package de.isc.konstanz.aml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ChannelWriter {
	static PrintWriter pWriter = null;
	
	public static void main(Channel channel) {
		try {
			startFile();
			createDeviceAndChannels(channel);
			endFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (pWriter != null) {
				pWriter.flush();
				pWriter.close();
			}
		}
	}

	private static void endFile() {
		// TODO Auto-generated method stub
		pWriter.println("</driver> \r\n" + "</configuration>");

	}

	public static void createDeviceAndChannels(Channel channel) {
		// TODO Auto-generated method stub
		// TODO: for new machine new channel -
		for (int i = 0; i <= channel.name.size(); i++) {
			try {
			if(i==0 || channel.folder.get(i)!=channel.folder.get(i-1)) {pWriter.println("<device id=\""+ channel.folder.get(i) +"\">\n" + 
					"<deviceAddress>"+ channel.adress.get(i) +"</deviceAddress>\n" +
					"<settings></settings>");}
			for (int j = 0; j<= channel.name.size(); j++) {
				try {
				pWriter.println(
						"<channel id=\""+channel.name.get(j).toString().replace(": ","_")+"\">\r\n" + 
						"        <description>"+channel.name.get(j)+"</description>\r\n" + 
						"        <channelAddress>key="+channel.key.get(j)+"</channelAddress>\r\n" + 
						"        <channelSettings>keyColumn"+channel.keyColumn.get(j)+";dataColumn="+channel.getDataColumn()+"</channelSettings>\r\n" + 
						"        <valueType>DOUBLE</valueType>\r\n" + 
						"		<unit></unit>\r\n" + 
						"        <samplingInterval>15s</samplingInterval>\r\n" + 
						"        <loggingSettings>*</loggingSettings>\r\n" + 
						"		<serverMapping id=\"opcua\">folder:"+channel.folder.get(j)+";subfolder"+channel.subFolder.get(j)+"</serverMapping>\r\n" + 
						"      </channel>");
				}
				catch(IndexOutOfBoundsException e) {
//					pWriter.println("</device>");
				}
			}
			pWriter.println("</device>");
		}
			catch(IndexOutOfBoundsException e) {
//				endFile();
			}
		}
	}

	private static void startFile() throws IOException {
		// TODO Auto-generated method stub
		pWriter = new PrintWriter(new BufferedWriter(new FileWriter("channelsTest.xml")));
		pWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n" + "<configuration>\r\n"
				+ "<driver id=\"mysql\">");

	}
}
