package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryLookUp {

	protected void lookUpFilmById(DatabaseAccessorObject dao, Scanner input) {

		String filmId = null;
		Film filmRequested = null;
		do {
			System.out.println("Enter the ID number of the film you would like to see");
			System.out.print(">> ");
			filmId = input.next();
			System.out.println();

			if (filmId.matches("^[0-9]*$")) {
				int parseFilmId = Integer.parseInt(filmId);

				try {
					filmRequested = dao.getFilmById(parseFilmId);
					if (filmRequested == null) {
						System.out.println("Id: " + parseFilmId + " is not a valid Id number. Please try again.");
					} else {
						System.out.println(dao.getFilmById(parseFilmId));
					}

				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		} while (!filmId.matches("^[0-9]*$") || filmRequested == null);
	}
	
	protected void lookUpFilmByKeyword(DatabaseAccessorObject dao, Scanner input) {
		
	}
}
