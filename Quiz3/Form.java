package Quiz3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Form 
{
	/* This class creates a form that allows the user
	 * to enter their name and have it displayed.
	 * Steve Miller, 3/25/15
	 */
	
	//Objects
	
	JFrame frame;
	JPanel panel1;
	JPanel borderPanel;
	JPanel buttonPanel;
	JLabel label1;
	JLabel label2;
	JTextField textName;
	JButton button;
	JButton exitButton;


	public Form() //constructor
	{
		createFrame();
	}
	
	
	//methods
	private void createFrame()
	{
		frame = new JFrame();
		frame.setBounds(200, 200, 400, 200);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(createBorderPanel());
		frame.setVisible(true);
	}
	
	private JPanel createBorderPanel()
	{
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createPanel(), BorderLayout.NORTH);
		borderPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		return borderPanel;
	}
	
	private JPanel createButtonPanel()
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		button = new JButton("This is where you click.");
		button.addActionListener(new ButtonListener());
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitListener());
		
		buttonPanel.add(button);
		buttonPanel.add(exitButton);
		
		return buttonPanel;
	}
	
	
	//for the panels
	private JPanel createPanel()
	{
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		label1 = new JLabel("Type your name.");
		textName = new JTextField(25);
		label2 = new JLabel();
		panel1.add(label1);
		panel1.add(textName);
		panel1.add(label2);
		
		return panel1;
	}
	
	
	//adds the ButtonListeners
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			label2.setText("Greetings, " + textName.getText() + "!!!");

		}
	}
		
	
		private class ExitListener implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
			
		}
		
	

}
