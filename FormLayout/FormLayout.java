package com.spconger.FormLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton; //import all of these
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormLayout {
	JFrame frame;
	JPanel panel1;
	JLabel label1;
	JLabel label2;
	JTextField textName;
	JButton button;
	
	public FormLayout() //constructor
	{
		createPanel();
		createFrame();
	}
	
	private void createFrame()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel1);
		frame.setVisible(true);
	}
	
	private void createPanel()
	{
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		label1 = new JLabel("Enter your name: ");
		textName = new JTextField(25);
		button = new JButton("Click");
		button.addActionListener(new ButtonListener());
		
		label2 = new JLabel();
		panel1.add(label1);
		panel1.add(textName);
		panel1.add(button);
		panel1.add(label2);
	}
	
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			label2.setText("Hello " + textName.getText());
		}
		
	}
}
