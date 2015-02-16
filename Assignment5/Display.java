package com.spconger.Assignment5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Display 
{
	private ReadFile file;
	
	private JFrame frame;
	private JPanel borderPanel;
	private JPanel greetingPanel;
	private JPanel buttonPanel;
	private JScrollPane scrollPane;
	private JLabel greetingPrompt;
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
		borderPanel.add(createScrollPane(), BorderLayout.CENTER);
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
	
	
	
}
