package com.spconger.SwingForms1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Form1 {
	
	JFrame frame = new JFrame();//basic window; just the box; declare at top, initialize later
	JLabel label = new JLabel("Hellay");
	
	public Form1() //the constructor; no return type, exactly same name as class
	{
		createFrame();
	}
	
	private void createFrame()
	{
		frame.setBounds(200, 200, 800, 800);
		frame.getContentPane().setBackground(Color.GRAY); //enumeration
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		Font f = new Font("Verdana", Font.BOLD, 20);
		label.setFont(f);
		JButton button = new JButton("Click me");
	
		button.setSize(100, 100);
		button.addActionListener(new ButtonListener());
		frame.add(button);
		frame.add(label);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener //interface; can only be read of encompassing class
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			label.setText("What do you want??");
			
		}
		
	}
}
