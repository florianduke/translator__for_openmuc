package de.isc.konstanz.aml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainForm{
	
	public static File selectedFile;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Channel channel = new Channel();
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Choose a File");		
		JFrame frame = new JFrame("aml2channel");
		JButton buttonLoad = new JButton("Load");
		buttonLoad.setBounds(50, 50, 100, 30);
		JButton buttonConvert = new JButton("Convert");	
		buttonConvert.setBounds(50, 90, 100, 30);
		JLabel labelForm = new JLabel("File...");
		
		frame.setTitle("AML to CHANNEL converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 300);
		frame.setResizable(true);
		frame.setLocation(50, 10);
		frame.setVisible(true);
		frame.add(buttonLoad);
		frame.add(buttonConvert);
		frame.add(labelForm);
		frame.revalidate();
		
		buttonLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue = fc.showOpenDialog(null);
				if(returnValue== JFileChooser.APPROVE_OPTION) {
//					selectedFile = fc.getSelectedFile();
			selectedFile= new File("C:\\Users\\fhe\\Desktop\\rena_stable.xml");
				}
			}
		});
		
		buttonConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AASReader reader = new AASReader();
				reader.main(selectedFile);
//				ChannelWriter.main(channel);
				
//				ChannelWriter write = new ChannelWriter();
//				write.main(channel);
			}
		});
		
	}

}
