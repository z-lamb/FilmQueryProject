package com.skilldistillery.filmquery.app;

import java.util.Iterator;
import java.util.List;

import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryPrint {

	private void printQuery(Film filmRequested) {
		System.out.println("Film: \t\t" + filmRequested.getTitle());
		System.out.println("Release Year: \t" + filmRequested.getReleaseYear());
		System.out.println("Rating: \t" + filmRequested.getRating());
		System.out.println("Description: \t" + filmRequested.getDescription());
		System.out.println("Language: \t" + filmRequested.getLanguageName());
		System.out.println("\n-------------");
	}
	
	protected void printSingleQuery(Film filmRequested) {
		printQuery(filmRequested);
	}
	
	protected void printMultipleQuery(List<Film> filmList) {
		Iterator<Film> iterator = filmList.iterator();

		while (iterator.hasNext()) {
			Film film = iterator.next();
			printQuery(film);
			
		}
	}
}
