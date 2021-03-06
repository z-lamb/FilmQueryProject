package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryLookUp {

	/*
	 * look up film by id
	 * if the filmId is a number it will parse out the int from it and attempt to get the film
	 * the proper dao is called and passes the id through to it
	 * this is wrapped in a try/catch so that if an exception is thrown it will be caught which will then print the stack trace
	 */
	protected Film lookUpFilmById(DatabaseAccessorObject dao, Scanner input, String filmId, Film filmRequested) {
		if (filmId.matches("^[0-9]*$")) {
			int parseFilmId = Integer.parseInt(filmId);
			try {
				filmRequested = dao.getFilmById(parseFilmId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filmRequested;
	}

	/*
	 * look up film by keyword
	 * attempt to get the film by the keyword that was passed in
	 * the proper dao is called and passes the id through to it
	 * this is wrapped in a try/catch so that if an exception is thrown it will be caught which will then print the stack trace
	 */
	protected List<Film> lookUpFilmByKeyword(DatabaseAccessorObject dao, Scanner input, String keyword, List<Film> keywordFilms) {
		try {
			keywordFilms = dao.getFilmsByKeyword(keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return keywordFilms;
	}
}
