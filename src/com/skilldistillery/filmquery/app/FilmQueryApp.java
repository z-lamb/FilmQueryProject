package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
		app.launch();
	}

  private void test() throws SQLException {
    Film film = db.getFilmById(1);
    if (film == null) {
    	System.out.println("Error with connection to database");
    }
  }

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		DatabaseAccessorObject dao = null;
		System.out.println("Welcome to the Film Database");
		
		int menuSelection;
		
		do {
			displayMenu();
			
			menuSelection = input.nextInt();
			if(menuSelection != 0) {
				menuOptions(menuSelection);
				
				dao = new DatabaseAccessorObject();
			}
			switch (menuSelection) {
			case 1:
				System.out.println("Enter the ID of the film you would like to see");
				int filmId = input.nextInt();
				try {
					dao.getFilmById(filmId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				
				break;
				default:
					System.out.println("Please make a selection from the menu ");
			}
			
		} while(menuSelection != 0);
			
	}

	private void menuOptions(int menuSelection) {
		// TODO Auto-generated method stub
		
	}

	private void displayMenu() {

		System.out.println("Choose from the menu options below");
		System.out.println("1. Look up a film by its id");
		System.out.println("2. Look up a film by a search keyword");
		System.out.println("0. Exit");
		System.out.print(">> ");
	}

}
