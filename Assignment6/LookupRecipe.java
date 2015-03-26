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

	/* ********* GLOBAL OBJECTS **************** */
	/* Declares the Swing objects to be used */

	// frame
	private JFrame frame;

	// panels and panes
	private JPanel borderPanel;
	private JPanel welcomePanel; // north
	private JPanel headingPanel;
	private JPanel mainMenuPanel;
	private JPanel messagePanel; // south
	private JPanel mainPanel;
	private JPanel recipesPanel; // center - left
	private JPanel recipePanel; // center - right
	
	private JScrollPane recipeScroll; 

	// labels
	private JLabel header;
	private JLabel messageLabel;
	private JLabel recipeName;
	
	// JTextArea
	private JTextArea recipeInstructions;

	// buttons
	private JButton exitButton;
	
	// JList
	private JList allRecipes;
	
	// List Model
	private DefaultListModel model;
	
	// Recipes Object
	private Recipes recipes;

	/* ********* CONSTRUCTOR **************** */

	public LookupRecipe(Recipes recipes) {
		
		this.recipes = recipes;
		
		createFrame();
	} // end NewRecipeDisplay Constructor

	/* ********* PRIVATE METHODS **************** */

	// creates the window/frame
	private void createFrame() {

		// instantiates frame as a new JFrame in memory.
		frame = new JFrame();

		// create the size of the frame
		// x, y, width, height
		frame.setBounds(200, 200, 500, 700);

		// if you close the window, it will stop the program
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		// add the panel to this frame
		frame.add(createBorderPanel());
		frame.setVisible(true);

	} // end createFrame()

	// creates the container for all the panels
	private JPanel createBorderPanel() {
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createWelcomePanel(), BorderLayout.NORTH);
		borderPanel.add(createSouthernPanel(), BorderLayout.SOUTH);
		borderPanel.add(createMainPanel(), BorderLayout.CENTER);
		return borderPanel;
	} // end createBorderPanel()

	// NORTH
	// creates the top-most part of the container
	// displays a welcome message and provides the user
	// with two buttons: add (which triggers the newRecipe panel)
	// and open (which triggers the openRecipe panel);
	private JPanel createWelcomePanel() {

		welcomePanel = new JPanel();
		welcomePanel.setLayout(new GridLayout(2, 1));

		// 1) HEADING PANEL
		headingPanel = new JPanel();
		headingPanel.setLayout(new FlowLayout());

		header = new JLabel("Welcome to Emily's Recipe Program!");
		header.setFont(new Font("Serif", Font.BOLD, 18));

		headingPanel.add(header);

		// 2) MENU PANEL
		mainMenuPanel = new JPanel();
		mainMenuPanel.setLayout(new FlowLayout());

		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonListener());

		mainMenuPanel.add(exitButton);

		// ADD TWO PANELS TO THE WELCOME PANEL
		welcomePanel.add(headingPanel);
		welcomePanel.add(mainMenuPanel);

		return welcomePanel;

	} // end createWelcomePanel() - NORTH

	// SOUTH
	private JPanel createSouthernPanel() {
		// this is where messages could go, but DECIDED NOT TO USE
		messagePanel = new JPanel();
		messagePanel.setLayout(new FlowLayout());
		messageLabel = new JLabel("This is the list of available recipes.  Click on a recipe.");
		messagePanel.add(messageLabel);
		return messagePanel;
	} // end createSouthernPanel()

	// CENTER
	private JPanel createMainPanel() {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));

		mainPanel.add(createRecipesPanel());
		mainPanel.add(createRecipePanel());

		return mainPanel;

	} // end createMainPanel()
	
	// CENTER - LEFT PANEL
	private JPanel createRecipesPanel(){
		recipesPanel = new JPanel();
		allRecipes = new JList();
		model = new DefaultListModel();
		
		ArrayList<Recipe> cookbook = recipes.getRecipeList();
		// loop through each recipe in our cookbook variable
		for (Recipe r : cookbook){
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
	
	// CENTER - RIGHT PANEL
	private JPanel createRecipePanel(){
		
		recipeName = new JLabel();
		recipeInstructions = new JTextArea();
		recipePanel = new JPanel();
		
		recipePanel.add(recipeName);
		recipePanel.add(recipeInstructions);
		
		return recipePanel;
	}

	// ***** EVENT HANDLERS *****

	// EXIT BUTTON
	// action for the exit button. this closes the frame
	private class ExitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// closes the frame and ends the program
			System.exit(0);
		} // end actionPerformed()

	}
	
	// SELECT A RECIPE FROM LIST ACTION 
	// action for the exit button. this closes the frame
	private class RecipeListListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			ArrayList<Recipe> cookbook = recipes.getRecipeList();
			
			for (Recipe r : cookbook){
				String name = (String) allRecipes.getSelectedValue(); 
				if(r.getName().equals(name)){
					// use r 
					recipeName.setText(r.getName());
					recipeInstructions.setText(r.getInstructions());
					
				}
			}
				
			// ListSelectionModel lsm = (ListSelectionModel)e.getSource();
			
		} // end actionPerformed()

		} // end LookupRecipeDisplay
}
