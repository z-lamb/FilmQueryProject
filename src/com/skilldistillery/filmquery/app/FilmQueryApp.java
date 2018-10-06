package com.skilldistillery.filmquery.app;

import java.sql.SQLException;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	// created to ensure connectivity to the database
	private DatabaseAccessor db = new DatabaseAccessorObject();
	
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
		new FilmQueryOperation().startOperation();
		
	}

}
