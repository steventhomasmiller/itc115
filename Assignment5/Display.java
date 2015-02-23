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
	final String FILEPATH ="C:\\temp\\textfile.txt";
	
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
	
	public Display()
	{
		createFrame();
		
	}
	
	private void createFrame()
	{
		frame = new JFrame();
		frame.setBounds(500, 500, 500, 500);
		frame.add(createBorderPanel());
		frame.setVisible(true);
	}
	
	private JPanel createBorderPanel()
	{
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createGreetingPanel(), BorderLayout.NORTH);
		borderPanel.add(createButtonPanel(), BorderLayout.CENTER);
		borderPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		return borderPanel;
	}
	
	private JPanel createGreetingPanel()
	{
		greetingPanel = new JPanel();
		greetingPanel.setLayout(new GridLayout(2,2));
		greetingPrompt = new JLabel("Welcome to ye olde write-text-to-file program");
		greetingPanel.add(greetingPrompt);
		return greetingPanel;
	}
	
	
	private JScrollPane createTextArea()
	{
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(50, 50, 400, 400);
		return scrollPane;
	}
	
	private JPanel createButtonPanel()
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		openButton = new JButton("Open");
		openButton.addActionListener(new OpenButtonListener());
		
		saveButton = new JButton ("Save");
		saveButton.addActionListener(new SaveButtonListener());
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonListener());
		
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(exitButton);
		
		return buttonPanel;		
	}
	
	private class OpenButtonListener implements ActionListener
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
	
	private class SaveButtonListener implements ActionListener
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
	
	private class ExitButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}
