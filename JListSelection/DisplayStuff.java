package com.spconger.JListSelection;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayStuff 
{
	private JFrame frame;
	private JList listStuff;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel borderPanel;
	private JButton button;
	private JLabel lblName;
	private JLabel lblPrice;
	
	private Stuff stuff;
	
	public DisplayStuff (Stuff s)
	{
		stuff = s; //stuff sucks
	}
	
	private void createFrame()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
	}
	
	private JPanel createBorderPanel()
	{
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createScrollPane(),BorderLayout.WEST);
		borderPanel.add(createPanel(),BorderLayout.EAST);
		
		return borderPanel;		
	}
	
	private JScrollPane createScrollPane()
	{
		listStuff = new JList<String>();
		listStuff.addListSelectionListener(new SelectionListener());
		scrollPane = new JScrollPane(listStuff);
		scrollPane.setBounds(20, 20, 100, 200);
		return scrollPane;
		
		
		/*scrollPane = new JScrollPane();
		ArrayList<String> myStuff = new ArrayList<String>();
		
		//scrollPane.setLayout(new FlowLayout());
		 * 
		 */
	}
	
	private JPanel createPanel()
	{
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		lblName = new JLabel();
		lblPrice=new JLabel();
		button = new JButton("Fill list");
		button.addActionListener(new ButtonListener());
		
		panel.add(lblName);
		panel.add(lblPrice);
		panel.add(button);
		
		return panel;	
	}
	
	private class ButtonListener implements ActionListener{}
}
