package com.emilyshine.Assignment_6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LookupRecipe {
	/*
	This class creates the swing form and lets the user create, enter new recipes
	Steve Miller, 3/26/15
	*/

	private JFrame frame; //declares frame

	// the panels and panes
	private JPanel borderPanel;
	private JPanel welcomePanel; 
	private JPanel headingPanel;
	private JPanel mainMenuPanel;
	private JPanel messagePanel; 
	private JPanel mainPanel;
	private JPanel recipesPanel; 
	private JPanel recipePanel;
	
	private JScrollPane recipeScroll; 

	// for the labels
	private JLabel header;
	private JLabel messageLabel;
	private JLabel recipeName;
	private JTextArea recipeInstructions;
	private JButton exitButton;
	private JList allRecipes;
	private DefaultListModel model;
	private Recipes recipes;



	public LookupRecipe(Recipes recipes) //constructor
	{
		this.recipes = recipes;
		createFrame();
	} 

	private void createFrame() //creates window
	{

		frame = new JFrame();
		frame.setBounds(300, 300, 550, 800);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(createBorderPanel());
		frame.setVisible(true);

	}

	
	private JPanel createBorderPanel() //creates panel
	{
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createWelcomePanel(), BorderLayout.NORTH);
		borderPanel.add(createSouthernPanel(), BorderLayout.SOUTH);
		borderPanel.add(createMainPanel(), BorderLayout.CENTER);
		return borderPanel;
	} 
	private JPanel createWelcomePanel() 
	{
		welcomePanel = new JPanel();
		welcomePanel.setLayout(new GridLayout(2, 1));

		headingPanel = new JPanel();
		headingPanel.setLayout(new FlowLayout());

		header = new JLabel("Welcome to Emily's Recipe Program!");
		header.setFont(new Font("Serif", Font.BOLD, 18));

		headingPanel.add(header);

		mainMenuPanel = new JPanel();
		mainMenuPanel.setLayout(new FlowLayout());

		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonListener());

		mainMenuPanel.add(exitButton);

		welcomePanel.add(headingPanel);
		welcomePanel.add(mainMenuPanel);

		return welcomePanel;

	} 

	// SOUTH
	private JPanel createSouthernPanel() 
	{
		messagePanel = new JPanel();
		messagePanel.setLayout(new FlowLayout());
		messageLabel = new JLabel("Here are the available recipes. Select one of those recipes, please.");
		messagePanel.add(messageLabel);
		return messagePanel;
	}

	private JPanel createMainPanel() 
	{
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));

		mainPanel.add(createRecipesPanel());
		mainPanel.add(createRecipePanel());

		return mainPanel;

	} 
	private JPanel createRecipesPanel()
	{
		recipesPanel = new JPanel();
		allRecipes = new JList();
		model = new DefaultListModel();
		
		ArrayList<Recipe> cookbook = recipes.getRecipeList();
		
		for (Recipe r : cookbook)
		{
			model.addElement(r.getName());
		}
		
		allRecipes.setModel(model);
		allRecipes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		allRecipes.setLayoutOrientation(JList.VERTICAL_WRAP);
		allRecipes.addListSelectionListener(new RecipeListListener());
		
		recipeScroll = new JScrollPane(allRecipes);
		recipeScroll.setPreferredSize(new Dimension(125, 100));
		
		recipesPanel.add(allRecipes);
		
		return recipesPanel;
		
	}
	
	private JPanel createRecipePanel(){
		
		recipeName = new JLabel();
		recipeInstructions = new JTextArea();
		recipePanel = new JPanel();
		
		recipePanel.add(recipeName);
		recipePanel.add(recipeInstructions);
		
		return recipePanel;
	}

	private class ExitButtonListener implements ActionListener //the event listeners
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{ //ends the program
			System.exit(0);
		}

	}
	
	private class RecipeListListener implements ListSelectionListener 
	{

		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			
			ArrayList<Recipe> cookbook = recipes.getRecipeList();
			
			for (Recipe r : cookbook)
			{
				String name = (String) allRecipes.getSelectedValue(); 
				if(r.getName().equals(name))
				{
					
					recipeName.setText(r.getName());
					recipeInstructions.setText(r.getInstructions());
					
				}
			}
				
			
			
		} 

	} 
}
