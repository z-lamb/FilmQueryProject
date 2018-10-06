package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryLookUp {

	private FilmQueryPrint printQuery = new FilmQueryPrint();
	protected Film lookUpFilmById(DatabaseAccessorObject dao, Scanner input) {

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
						System.out.println("The film you requested is: ");
						printQuery.printQuery(filmRequested);

					}

				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		} while (!filmId.matches("^[0-9]*$") || filmRequested == null);

		return filmRequested;
	}

	protected List<Film> lookUpFilmByKeyword(DatabaseAccessorObject dao, Scanner input) {
		String keyword;
		List<Film> keywordFilms = null;

		System.out.println("Enter the keyword of the film you would like to see");
		System.out.print(">> ");
		keyword = input.next();
		System.out.println();

		try {
			keywordFilms = dao.getFilmsByKeyword(keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (keywordFilms.size() == 0) {
			System.out.println("There were no films that containted the keyword: " + keyword);
		} else {
			System.out.println("Here are the films that contained the keyword: " + keyword + "\n");

			printQuery.printMultipleQuery(keywordFilms);
			
		}

		return keywordFilms;
	}
}
