package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryOperation {

	private FilmQueryMenus filmQueryMenus = new FilmQueryMenus();
	private FilmQueryLookUp lookUp;
	private Film filmReturned;
	private List<Film> filmListReturned;
	private String subMenuSelection;
	private FilmQueryPrint printQuery = new FilmQueryPrint();
	
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
			filmReturned = lookUp.lookUpFilmById(dao, input);
			subMenuOptions(filmReturned, input);
			break;
		case "2":
			filmListReturned = lookUp.lookUpFilmByKeyword(dao, input);
			subMenuOptions(filmListReturned, input);
			break;
		case "0":
			return;
		
		default:
			System.out.println("Please make a selection from the menu ");
		}
	}
	
	private void subMenuOptions(List<Film> filmListReturned2, Scanner input) {

		do {
			filmQueryMenus.subMenu();
			subMenuSelection = input.next();
			switch(subMenuSelection) {
				case "1":
					System.out.println();
					System.out.println("Here are all of the film details of the movie requested: ");
					printQuery.printQueryAll(filmReturned);
					return;
				case "0":
					return;
				default:
					System.out.println("Make a proper selection");
					
			}
		} while (!subMenuSelection.equals("0"));
	}

	private void subMenuOptions(Film filmReturned, Scanner input) {
		do {
			filmQueryMenus.subMenu();
			subMenuSelection = input.next();
			switch(subMenuSelection) {
				case "1":
					System.out.println();
					System.out.println("Here are all of the film details of the movie requested: ");
					printQuery.printQueryAll(filmReturned);
					return;
				case "0":
					return;
				default:
					System.out.println("Make a proper selection");
					
			}
		} while (!subMenuSelection.equals("0"));
	}
}
