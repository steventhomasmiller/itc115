package com.spconger.Assignment4a;

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
public class CardForm 
{
	private JFrame frame;
	 private JPanel borderPanel;
	 private JPanel NewCardPanel;
	 private JPanel buttonPanel;
	 private JScrollPane scrollPane;
	 private JList wordList;
	 private JLabel wordPrompt;
	 private JTextField wordText;
	 private JLabel defPrompt;
	 private JTextField defText;
	 private JButton addButton;
	 private JButton getWordsButton;
	 private JButton exitButton;
	 
	 private Deck deck; //match class name
	 
	 public CardForm() //constructor
	 {
		  createFrame();
		  deck = new Deck();
	 }
	 
	 private void createFrame()
	 {
		  frame = new JFrame();
		  frame.setBounds(100, 100, 300, 300);
		  frame.add(createBorderPanel());
		  frame.setVisible(true);
	 }
	 
	 private JPanel createBorderPanel()
	 {
		  borderPanel = new JPanel();
		  borderPanel.setLayout(new BorderLayout());
		  borderPanel.add(createNewCardPanel(), BorderLayout.NORTH);
		  borderPanel.add(createScrollPane(),BorderLayout.CENTER);
		  borderPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		  return borderPanel;
	 }
		 
	private JPanel createNewCardPanel()
	{
		  NewCardPanel = new JPanel();
		  NewCardPanel.setLayout(new GridLayout(2,2));
		  wordPrompt=new JLabel("Enter Word");
		  wordText = new JTextField();
		  defPrompt = new JLabel("Enter Definition");
		  defText = new JTextField();
		  NewCardPanel.add(wordPrompt);
		  NewCardPanel.add(wordText);
		  NewCardPanel.add(defPrompt);
		  NewCardPanel.add(defText);
		  return NewCardPanel;
	}
		 
	private JScrollPane createScrollPane()
	{
		  wordList = new JList(); //just a list box
		  //add the selection listener to the list
		  //wordlist.addListSelectionListener(new SelectionListener());
		  scrollPane = new JScrollPane(wordList);
		  scrollPane.setBounds(20, 20, 100, 200);
		  
		  return scrollPane;
	}
		 
	private JPanel createButtonPanel()
	{
		  buttonPanel = new JPanel();
		  buttonPanel.setLayout(new FlowLayout());
		  addButton = new JButton("Add Word");
		  addButton.addActionListener(new AddButtonListener());
		  getWordsButton = new JButton("Get Words");
		  getWordsButton.addActionListener(new GetWordsListener());
		  exitButton = new JButton("Exit");
		  exitButton.addActionListener(new ExitListener());
		  
		  buttonPanel.add(addButton);
		  buttonPanel.add(getWordsButton);
		  buttonPanel.add(exitButton);
		  
		  return buttonPanel;
	}
		 
	private class AddButtonListener implements ActionListener
	{
		  @Override
		  public void actionPerformed(ActionEvent e) 
		  {
			   Deck d = new Deck();
			   d.setWord(wordText.getText());
			   d.setDefinition(defText.getText());
			   deck.addWord(w);
			   
			   wordText.setText(""); //cleared out for new entry
			   defText.setText("");
		  }
		  
	}
		 
	private class GetWordsListener implements ActionListener
		 
	{
		  @Override
		  public void actionPerformed(ActionEvent e) 
		  {
			   ArrayList<Card> cards = deck.getWords();
			   DefaultListModel model = new DefaultListModel();
			   
			   for(Card c: cards)
			   {
			    	model.addElement(w.toString());
			   }
			   	wordList.setModel(model);
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
} //ends class


