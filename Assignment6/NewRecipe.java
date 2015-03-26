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
	/*
	This class allows the user to submit the recipe ingredients and clears the form.
	Steve Miller, 3/26/15
	*/

	// declares the frame
	private JFrame frame;

	private JPanel borderPanel;
	private JPanel welcomePanel;
	private JPanel headingPanel;
	private JPanel mainMenuPanel;

	private JPanel southernPanel; 
	private JPanel instructionsPanel;
	private JPanel submitPanel;
	private JPanel messagePanel;

	private JPanel mainPanel; 
	private JPanel recipePanel; 
	private JPanel ingredientPanel; 

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

	public NewRecipe() //constructor 
	{
		recipes = new Recipes();
		createFrame();
	}

	private void createFrame() //creates the frame
	{
		frame = new JFrame();
		frame.setBounds(50, 50, 800, 700);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		frame.add(createBorderPanel());
		frame.setVisible(true);

	} 

	
	private JPanel createBorderPanel() //creates panels
	{
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createWelcomePanel(), BorderLayout.NORTH);
		borderPanel.add(createMainPanel(), BorderLayout.CENTER);
		borderPanel.add(createSouthernPanel(), BorderLayout.SOUTH);
		return borderPanel;
	}
	
	private JPanel createWelcomePanel() //north container
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

		openButton = new JButton("Open");
		openButton.addActionListener(new OpenButtonListener());

		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonListener());

		mainMenuPanel.add(openButton);
		mainMenuPanel.add(exitButton);

		welcomePanel.add(headingPanel);
		welcomePanel.add(mainMenuPanel);

		return welcomePanel;

	} 

	private JPanel createMainPanel() //center container
	{

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 3));

		mainPanel.add(createInstructionsPanel());
		mainPanel.add(createIngredientPanel());
		mainPanel.add(createRecipePanel());

		return mainPanel;

	} 


	private JPanel createInstructionsPanel() //left of center
	{
		instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new FlowLayout());

		nameHeadline = new JLabel ("1. Add recipre name and instructions.");
		nameHeadline.setFont(new Font("Sans Serif", Font.BOLD, 15));
	
		nameLabel = new JLabel("Recipe Name: ");
		namePrompt = new JTextField(10);

		instructionsLabel = new JLabel("Enter recipe instructions: ");
		instructionsBox = new JTextArea(10, 20);
		submitInstructionsButton = new JButton("Submit");
		submitInstructionsButton.addActionListener(new SubmitInstructionsButtonListener());

		instructionsPanel.add(nameHeadline);
		instructionsPanel.add(nameLabel);
		instructionsPanel.add(namePrompt);
		instructionsPanel.add(instructionsLabel);
		instructionsPanel.add(instructionsBox);
		instructionsPanel.add(submitInstructionsButton);

		return instructionsPanel;

	} // end createRecipePanel()

	
	private JPanel createIngredientPanel() //true center
	{

		ingredientPanel = new JPanel();
		ingredientPanel.setLayout(new FlowLayout());

		ingredientHeadline = new JLabel("2. Add ingredients");
		ingredientHeadline.setFont(new Font("Sans Serif", Font.BOLD, 16));

		spacer = new JLabel("                       ");
		ingredientName = new JLabel("Name: ");
		unitSizeLabel = new JLabel("Unit Size: ");
		caloriesLabel = new JLabel("alories: ");
		fatLabel = new JLabel("Fat: ");
		proteinLabel = new JLabel("Protein: ");
		carbsLabel = new JLabel("Carbs: ");

		ingredientNamePrompt = new JTextField(8);
		unitSizeTextField = new JTextField(9);
		caloriesTextField = new JTextField(10);
		fatTextField = new JTextField(12);
		proteinTextField = new JTextField(10);
		carbsTextField = new JTextField(11);

		addIngredientButton = new JButton("Add Ingredient");
		addIngredientButton.addActionListener(new AddIngredientButtonListener());

		// adds to the ingredient panel
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
	private JPanel createRecipePanel() 
	{

		recipePanel = new JPanel();
		recipePanel.setLayout(new FlowLayout());
		recipeHeadline = new JLabel("See this recipe: ");
		recipeHeadline.setFont(new Font("Sans Serif", Font.BOLD, 15));

		displayNameLabel = new JLabel();
		displayIngredientList = new JList();
		displayInstructionsLabel = new JTextArea();

		recipePanel.add(recipeHeadline);
		recipePanel.add(displayNameLabel);
		recipePanel.add(displayIngredientList);
		recipePanel.add(displayInstructionsLabel);

		return recipePanel;

	} 
	
	private JPanel createSouthernPanel() //south panel
	{

		southernPanel = new JPanel();
		southernPanel.setLayout(new GridLayout(3, 1));

		// this is where the submit button goes
		submitPanel = new JPanel();
		submitPanel.setLayout(new FlowLayout());
		submitLabel = new JLabel("                                             "
				+ "                3. Upload Recipe to Cookbook.");
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
	} 
	private class OpenButtonListener implements ActionListener //opens recipe display panel
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			LookupRecipe lr = new LookupRecipe(recipes);
			
		}

	} 


	private class ExitButtonListener implements ActionListener //closes frame 
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		} 

	} // end ExitButtonListener class


	private class AddIngredientButtonListener implements ActionListener //adds ingredient to item
	{

		@Override
		public void actionPerformed(ActionEvent e) {

			Ingredient i = new Ingredient(); //creates ingredient

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
			r.addItem(i);
			
			// clears the way for a new recipe
			ingredientNamePrompt.setText("");
			unitSizeTextField.setText("");
			caloriesTextField.setText("");
			fatTextField.setText("");
			proteinTextField.setText("");
			carbsTextField.setText("");
	
			messageLabel.setText("A NEW ingredient has been added to " + r.getName() + ".");

		} 

	} 

	private class SubmitInstructionsButtonListener implements ActionListener //submits recipe
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			r = new Recipe();
			r.setName(namePrompt.getText());
			r.setInstructions(instructionsBox.getText());
															
			// success message
			messageLabel.setText("A recipe '" + r.getName()
					+ "' has been created.");

			displayNameLabel.setText(r.getName());
			displayInstructionsLabel.setText(r.getInstructions());

		} 

	}

	private class UploadRecipeListener implements ActionListener //saves recipe to list
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			recipes.addItem(r);

			namePrompt.setText("");
			instructionsBox.setText("");

			messageLabel.setText("Recipe has been stored in the highly secure recipe databank.");
			
			ArrayList<Recipe> cookbook = recipes.getRecipeList();
	
			for (Item r : cookbook){
				System.out.println(r.getName());
			}

		} 

	} 

} 
