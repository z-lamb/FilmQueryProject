package com.skilldistillery.filmquery.app;

import java.util.Iterator;
import java.util.List;

import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryPrint {

	protected void printQuery(Film filmRequested) {
		System.out.println("Film: \t\t " + filmRequested.getTitle());
		System.out.println("Release Year: \t " + filmRequested.getReleaseYear());
		System.out.println("Rating: \t " + filmRequested.getRating());
		System.out.println("Description: \t " + filmRequested.getDescription());
		System.out.println("Language: \t " + filmRequested.getLanguageName());
		System.out.print("Actors:");
		for (int i = 0; i < filmRequested.getActors().size(); i++) {
			StringBuilder stringBuilder = new StringBuilder();
			System.out.println("\t\t " + stringBuilder.append(filmRequested.getActors().get(i).getFirstName() + " ")
														.append(filmRequested.getActors().get(i).getLastName()));
		}

		System.out.println("\n--------------------------\n");
	}

	protected void printQueryAll(Film filmRequested) {
		System.out.println("Film: \t\t " + filmRequested.getTitle());
		System.out.println("Description: \t " + filmRequested.getDescription());
		System.out.println("Release Year: \t " + filmRequested.getReleaseYear());
		System.out.println("Language: \t " + filmRequested.getLanguageName());
		System.out.println("Rental Duration: " + filmRequested.getRentalDuration());
		System.out.println("Rental Rate: \t $" + filmRequested.getRentalRate());
		System.out.println("Length: \t " + filmRequested.getLength());
		System.out.println("Cost To Replace: $" + filmRequested.getReplacementCost());
		System.out.println("Rating: \t " + filmRequested.getSpecialFeatures());
		System.out.print("Actors:");
		for (int i = 0; i < filmRequested.getActors().size(); i++) {
			StringBuilder stringBuilder = new StringBuilder();
			System.out.println("\t\t " + stringBuilder.append(filmRequested.getActors().get(i).getFirstName() + " ")
														.append(filmRequested.getActors().get(i).getLastName()));
		}

		System.out.println("\n--------------------------\n");
	}

	protected void printMultipleQuery(List<Film> filmList) {
		Iterator<Film> iterator = filmList.iterator();

		while (iterator.hasNext()) {
			Film film = iterator.next();
			printQuery(film);
		}
	}

	protected void printMultipleQueryAll(List<Film> filmList) {
		Iterator<Film> iterator = filmList.iterator();

		while (iterator.hasNext()) {
			Film film = iterator.next();
			printQueryAll(film);
		}
	}

}
