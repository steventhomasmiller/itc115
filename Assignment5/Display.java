package com.spconger.Assignment5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Display 
{
	/* This class creates the form and provides buttons 
	 * to write and read to the files
	 * Steve Miller, 2/20/15
	 */
	
	final String FILEPATH ="/Users/stevemiller/Desktop/myFile.txt"; //worded this way for Mac.
	
	private JFrame frame;
	private JPanel borderPanel;
	private JPanel greetingPanel;
	private JPanel buttonPanel;
	private JScrollPane scrollPane;
	private JLabel greetingPrompt;
	private JTextArea textArea;
	private JButton openButton;
	private JButton saveButton;
	private JButton exitButton;
	
	public Display() //constructor
	{
		createFrame();
	}
	
	private void createFrame()
	{
		frame = new JFrame();
		frame.setBounds(500, 500, 500, 500); //good to have symmetry
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);  //closes program when user exits
		frame.add(createBorderPanel());
		frame.setVisible(true);
	}
	
	private JPanel createBorderPanel() //creates the panels
	{
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createGreetingPanel(), BorderLayout.NORTH);
		borderPanel.add(createTextArea(), BorderLayout.CENTER);
		borderPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		return borderPanel;
	}
	
	private JPanel createGreetingPanel() //ye olde welcomer
	{
		greetingPanel = new JPanel();
		greetingPanel.setLayout(new GridLayout(2,2));
		greetingPrompt = new JLabel("Welcome to ye olde write-text-to-file program");
		greetingPanel.add(greetingPrompt);
		return greetingPanel;
	}
	
	
	private JScrollPane createTextArea() //creates scroll pane
	{
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(50, 50, 400, 400);
		return scrollPane;
	}
	
	private JPanel createButtonPanel() //creates the buttons
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		openButton = new JButton("Open");
		openButton.addActionListener(new OpenButtonListener());
		
		saveButton = new JButton ("Save");
		saveButton.addActionListener(new SaveButtonListener());
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonListener());
		
		//adds the buttons
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(exitButton);
		
		return buttonPanel;		
	}
	
	private class OpenButtonListener implements ActionListener //opens text file
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ReadFile rf = new ReadFile(FILEPATH);
			String content;
			
			try
			{
				content = rf.getText();
				
				textArea.setText(content);
			}
			catch (IOException err)
			{
				textArea.setText(err.getMessage());
			}
		}
	}
	
	private class SaveButtonListener implements ActionListener //adds text to the file
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				String textInBox = textArea.getText();
				
				WriteFile wf = new WriteFile(FILEPATH);
				wf.addText(textInBox);
				
				wf.closeFile();
			}
			catch (IOException err)
			{
				textArea.setText(err.getMessage());
			}
		}
	}
	
	private class ExitButtonListener implements ActionListener //exits program
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}
