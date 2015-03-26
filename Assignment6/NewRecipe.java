package com.emilyshine.Assignment_6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewRecipe {

	// ***** GLOBAL OBJECT DECLARATIONS *****

	// frame
	private JFrame frame;

	private JPanel borderPanel;
	private JPanel welcomePanel; // north
	private JPanel headingPanel;
	private JPanel mainMenuPanel;

	private JPanel southernPanel; // south
	private JPanel instructionsPanel; // south - 1
	private JPanel submitPanel; // south - 2
	private JPanel messagePanel; // south - 3

	private JPanel mainPanel; // center
	private JPanel recipePanel; // center - 1
	private JPanel ingredientPanel; // center - 2

	// labels
	private JLabel spacer;
	private JLabel messageLabel;
	private JLabel header;
	private JLabel nameLabel;
	private JLabel instructionsLabel;
	private JLabel ingredientHeadline;
	private JLabel recipeHeadline;
	private JLabel ingredientName;
	private JLabel unitSizeLabel;
	private JLabel caloriesLabel;
	private JLabel fatLabel;
	private JLabel proteinLabel;
	private JLabel carbsLabel;
	private JLabel displayNameLabel;
	private JTextArea displayInstructionsLabel;
	private JLabel nameHeadline;
	private JLabel submitLabel;

	// ingredient list
	private JList displayIngredientList;

	// text fields
	private JTextField namePrompt;
	private JTextField ingredientNamePrompt;
	private JTextField unitSizeTextField;
	private JTextField caloriesTextField;
	private JTextField fatTextField;
	private JTextField proteinTextField;
	private JTextField carbsTextField;

	private JTextArea instructionsBox;

	// buttons
	private JButton openButton;
	private JButton addIngredientButton;
	private JButton submitInstructionsButton;
	private JButton uploadRecipeButton;
	private JButton exitButton;
	
	// instantiate a recipe and RECIPES
	private Recipe r;
	private Recipes recipes;

	// ***** CONSTRUCTOR *****

	public NewRecipe() {
		recipes = new Recipes();
		createFrame();
	}

	// ***** PRIVATE METHODS *****
	// creates the window/frame
	private void createFrame() {

		// instantiates frame as a new JFrame
		frame = new JFrame();

		// create the size of the frame
		// x, y, width, height
		frame.setBounds(50, 50, 800, 700);

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
		borderPanel.add(createMainPanel(), BorderLayout.CENTER);
		borderPanel.add(createSouthernPanel(), BorderLayout.SOUTH);
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

		// 1) THE HEADING PANEL 
		headingPanel = new JPanel();
		headingPanel.setLayout(new FlowLayout());

		header = new JLabel("Welcome to Emily's Recipe Program!");
		header.setFont(new Font("Serif", Font.BOLD, 18));

		headingPanel.add(header);

		// 2) MENU PANEL
		mainMenuPanel = new JPanel();
		mainMenuPanel.setLayout(new FlowLayout());

		openButton = new JButton("Open");
		openButton.addActionListener(new OpenButtonListener());

		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonListener());

		mainMenuPanel.add(openButton);
		mainMenuPanel.add(exitButton);

		// ADD THE TWO PANELS TO THE WELCOME PANEL
		welcomePanel.add(headingPanel);
		welcomePanel.add(mainMenuPanel);

		return welcomePanel;

	} // end createWelcomePanel() ------ NORTH

	// CENTER CONTAINER
	private JPanel createMainPanel() {

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 3));

		mainPanel.add(createInstructionsPanel());
		mainPanel.add(createIngredientPanel());
		mainPanel.add(createRecipePanel());

		return mainPanel;

	} // end createMainPanel()

	// CENTER-LEFT
	private JPanel createInstructionsPanel() {

		// this is where the user enters the recipe name and instructions
		instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new FlowLayout());

		nameHeadline = new JLabel ("1. Add Name and Instructions.");
		nameHeadline.setFont(new Font("Sans Serif", Font.BOLD, 15));
	
		nameLabel = new JLabel("Recipe Name: ");
		namePrompt = new JTextField(10);

		instructionsLabel = new JLabel("Enter the recipe instructions: ");
		instructionsBox = new JTextArea(10, 20);
		submitInstructionsButton = new JButton("Submit Name and Instructions");
		submitInstructionsButton
				.addActionListener(new SubmitInstructionsButtonListener());

		instructionsPanel.add(nameHeadline);
		instructionsPanel.add(nameLabel);
		instructionsPanel.add(namePrompt);
		instructionsPanel.add(instructionsLabel);
		instructionsPanel.add(instructionsBox);
		instructionsPanel.add(submitInstructionsButton);

		return instructionsPanel;

	} // end createRecipePanel()

	// CENTER-CENTER
	private JPanel createIngredientPanel() {

		ingredientPanel = new JPanel();
		ingredientPanel.setLayout(new FlowLayout());

		ingredientHeadline = new JLabel("2. Add Each Ingredient");
		ingredientHeadline.setFont(new Font("Sans Serif", Font.BOLD, 15));

		spacer = new JLabel("                       ");
		ingredientName = new JLabel("Ingredient Name: ");
		unitSizeLabel = new JLabel("Enter Unit Size: ");
		caloriesLabel = new JLabel("Enter Calories: ");
		fatLabel = new JLabel("Enter Fat: ");
		proteinLabel = new JLabel("Enter Protein: ");
		carbsLabel = new JLabel("Enter Carbs: ");

		ingredientNamePrompt = new JTextField(8);
		unitSizeTextField = new JTextField(9);
		caloriesTextField = new JTextField(10);
		fatTextField = new JTextField(12);
		proteinTextField = new JTextField(10);
		carbsTextField = new JTextField(11);

		addIngredientButton = new JButton("Add Ingredient");
		addIngredientButton.addActionListener(new AddIngredientButtonListener());

		// add components to the ingredient panel
		ingredientPanel.add(ingredientHeadline);
		ingredientPanel.add(spacer);
		ingredientPanel.add(ingredientName);
		ingredientPanel.add(ingredientNamePrompt);
		ingredientPanel.add(unitSizeLabel);
		ingredientPanel.add(unitSizeTextField);
		ingredientPanel.add(caloriesLabel);
		ingredientPanel.add(caloriesTextField);
		ingredientPanel.add(fatLabel);
		ingredientPanel.add(fatTextField);
		ingredientPanel.add(proteinLabel);
		ingredientPanel.add(proteinTextField);
		ingredientPanel.add(carbsLabel);
		ingredientPanel.add(carbsTextField);
		ingredientPanel.add(addIngredientButton);

		return ingredientPanel;

	} // end createIngredientPanel()

	// CENTER-RIGHT
	private JPanel createRecipePanel() {

		recipePanel = new JPanel();
		recipePanel.setLayout(new FlowLayout());
		recipeHeadline = new JLabel("Your Recipe is Below ");
		recipeHeadline.setFont(new Font("Sans Serif", Font.BOLD, 15));

		displayNameLabel = new JLabel();
		displayIngredientList = new JList();
		displayInstructionsLabel = new JTextArea();

		recipePanel.add(recipeHeadline);
		recipePanel.add(displayNameLabel);
		recipePanel.add(displayIngredientList);
		recipePanel.add(displayInstructionsLabel);

		return recipePanel;

	} // end createRecipePanel()

	// SOUTH
	// the message panel displays confirmation messages for the user
	private JPanel createSouthernPanel() {

		southernPanel = new JPanel();
		southernPanel.setLayout(new GridLayout(3, 1));

		// this is where the submit button goes
		submitPanel = new JPanel();
		submitPanel.setLayout(new FlowLayout());
		submitLabel = new JLabel("                                             "
				+ "                         3. Upload Recipe to Cookbook.");
		submitLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));
		uploadRecipeButton = new JButton("Upload Recipe");
		uploadRecipeButton.addActionListener(new UploadRecipeListener());
		submitPanel.add(uploadRecipeButton);

		// this is where messages go
		messagePanel = new JPanel();
		messagePanel.setLayout(new FlowLayout());
		messageLabel = new JLabel("...");
		messagePanel.add(messageLabel);

		// add the above to the submitPanel
		southernPanel.add(submitLabel);
		southernPanel.add(submitPanel);
		southernPanel.add(messagePanel);

		return southernPanel;
	} // end messagePanel() ----- SOUTH

	/* ********* EVENT HANDLERS & INTERFACES ******** */

	// OPEN BUTTON
	// this button will open the LookupRecipe display/frame
	private class OpenButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * THIS OPENS A NEW FRAME... calls the LookupRecipe constructor and
			 * passes Recipes class
			 */

			LookupRecipe lr = new LookupRecipe(recipes);
			
		} // end actionPerformed

	} // end OpenButtonListener class

	// EXIT BUTTON
	// action for the exit button, closes the frame
	private class ExitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// closes the frame and ends the program
			System.exit(0);
		} // end actionPerformed()

	} // end ExitButtonListener class

	// ADD INGREDIENT BUTTON
	// adds ingredient item to the recipe
	private class AddIngredientButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * 
			 * 1. adds ingredient to recipe, 2. clears the form, 3. updates the
			 * Recipe panel
			 */

			// Creates ingredient
			Ingredient i = new Ingredient();
			
			// set fields to i
			i.setName(ingredientNamePrompt.getText());

			i.setUnitSize(unitSizeTextField.getText());

			// converts text to double, then set the double
			double cal = Double.parseDouble(caloriesTextField.getText());
			i.setCalories(cal);

			double fat = Double.parseDouble(fatTextField.getText());
			i.setCalories(fat);

			double pro = Double.parseDouble(proteinTextField.getText());
			i.setCalories(pro);

			double carb = Double.parseDouble(carbsTextField.getText());
			i.setCalories(carb);

			// add ingredient to recipe
			r.addItem(i);
			
			// clear out for new entry
			ingredientNamePrompt.setText("");
			unitSizeTextField.setText("");
			caloriesTextField.setText("");
			fatTextField.setText("");
			proteinTextField.setText("");
			carbsTextField.setText("");
			
			// update center-right panel with ingredient (optional)
			
			
			// success message
			messageLabel.setText("An ingredient has been added to " + r.getName() + ".");

		} // end actionPerformed()

	} // end AddIngredientButtonListener class

	// SUBMIT RECIPE NAME AND INSTRUCTIONS BUTTON
	private class SubmitInstructionsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			r = new Recipe();
			// add the Recipe (r) properties
			r.setName(namePrompt.getText());
			r.setInstructions(instructionsBox.getText()); // get the instructions
															
			// success message
			messageLabel.setText("Recipe '" + r.getName()
					+ "' has been created.");

			// display in center right panel
			displayNameLabel.setText(r.getName());
			displayInstructionsLabel.setText(r.getInstructions());

		} // end actionPerformed()

	} // end SubmitInstructionsButtonListener class

	// UPLOAD RECIPE BUTTON
	// This saves the recipe to list of recipes by saving to Recipes class
	private class UploadRecipeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 1 Submit recipe r to Recipes
			recipes.addItem(r);

			// clear out for new entry
			namePrompt.setText("");
			instructionsBox.setText("");

			// success message
			messageLabel.setText("Recipe has been uploaded.");
			
			// temp array list and set equal to all recipes in recipe list object
			ArrayList<Recipe> cookbook = recipes.getRecipeList();
			// loop through each recipe in our cookbook variable
			for (Item r : cookbook){
				System.out.println(r.getName());
			}

		} // end actionPerformed()

	} // end SubmitInstructionsButtonListener class

} // end NewRecipe class
