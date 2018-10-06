package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;

public class FilmQueryOperation {

	private FilmQueryMenus filmQueryMenus = new FilmQueryMenus();
	private FilmQueryLookUp lookUp;
	
	/* Declared dao and initialized to null as to not create a new item on the heap
	 * unless it is needed */
	private DatabaseAccessorObject dao = null;
	
	public void startOperation(){
		Scanner input = new Scanner(System.in);
		
		startUserInterface(input);
		
		input.close();
		
	}
	
	private void startUserInterface(Scanner input) {

		System.out.println("Welcome to the Film Database");

		// Declared menuSelection to be able to use in the do while loop
		String menuSelection;
		do {
			filmQueryMenus.mainMenu();
			menuSelection = input.next();
			System.out.println();
			menuOptions(menuSelection, input);

		} while (!menuSelection.equals("0"));

	}
	
	private void menuOptions(String menuSelection, Scanner input) {

		/* Only create new object on heap if user decides to look something up and it
		 * hasn't already been created */
		if (menuSelection != "0") {
			if (dao == null) {
				dao = new DatabaseAccessorObject();
				lookUp = new FilmQueryLookUp();
			}
		}

		// Switch for menu selection
		switch (menuSelection) {
		case "1":
			lookUp.lookUpFilmById(dao, input);
			break;

		case "2":
			
			
			break;
		
		case "0":
			return;
		
		default:
			System.out.println("Please make a selection from the menu ");
		}
	}
}
