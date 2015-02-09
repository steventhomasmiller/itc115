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
	private Deck deck;
	
	private JFrame frame;
	private JPanel borderPanel;
	private JPanel greetingPanel;
	private JPanel buttonPanel;
	private JScrollPane scrollPane;
	private JList cardList;
	private JLabel greetingPrompt;
	private JLabel cardsInHandPrompt;
	private JTextField numberOfCardsText;
	private JButton dealButton;
	//private JButton getWordsButton;
	private JButton exitButton;
	
	public CardForm()
	{
		deck = new Deck();
		createFrame();
	}
	
	private void createFrame()
	{
		frame = new JFrame();
		frame.setBounds(200, 200, 200, 200);
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
		greetingPrompt = new JLabel("Welcome to ye olde card game.");
		greetingPanel.add(greetingPrompt);
		return greetingPanel;
	}
	
	private JScrollPane createScrollPane()
	{
		cardList = new JList();
		scrollPane = new JScrollPane(cardList);
		scrollPane.setBounds(20, 20, 200, 350);
		return scrollPane;
	}
	
	private JPanel createButtonPanel()
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		cardsInHandPrompt = new JLabel("Cards per hand: ");
		numberOfCardsText = new JTextField(2);
		
		dealButton = new JButton("Deal cards: ");
		dealButton.addActionListener(new DealButtonListener());
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitListener());
		
		buttonPanel.add(cardsInHandPrompt);
		buttonPanel.add(numberOfCardsText);
		buttonPanel.add(dealButton);
		buttonPanel.add(exitButton);
		
		return buttonPanel;
		
	}
	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	private class DealButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String cardsInHand = numberOfCardsText.getText();
			int numberOfCards = Integer.parseInt(cardsInHand);
			
			ArrayList<Card> cards = deck.cardHand(numberOfCards);
			
			DefaultListModel model = new DefaultListModel();
			
			for (Card c: cards)
			{
				model.addElement(c.toString());
			}
			cardList.setModel(model);
		}
	}
	
} //ends class


