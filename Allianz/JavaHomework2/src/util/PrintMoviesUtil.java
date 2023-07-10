package util;

import model.Movie;

import java.util.List;
import java.util.Scanner;

public class PrintMoviesUtil {

    public static void printMovies(List<Movie> listToPrint, Scanner scanner) {
        if (listToPrint.isEmpty()) {
            System.out.println("There are no movies in the movie list. Add one to get started. \n");
        } else {
            System.out.println("Printing " + listToPrint.size() + " movies.");
            for (Movie movie : listToPrint) {
                System.out.println("ID: " + movie.getMovieId()
                        + " - Movie Name: " + movie.getMovieName()
                        + " - Director: " + movie.getDirector());
            }
            System.out.println();

            boolean showDetails = true;
            while (showDetails) {

                boolean isMovieSelected = false;

                int selectedMovieId;

                do {
                    System.out.println("Enter a movie's id to see details: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a valid id!");
                        scanner.next();
                    }
                    selectedMovieId = scanner.nextInt();

                    if (selectedMovieId <= 0 || selectedMovieId > listToPrint.size()) {
                        System.out.println("Enter a valid id!");
                    } else {
                        scanner.nextLine();

                        boolean isMovieFound = false;
                        for (Movie movie : listToPrint) {
                            if (movie.getMovieId() == selectedMovieId) {
                                System.out.println(movie);
                                isMovieFound = true;
                            }
                        }
                        if(isMovieFound) {
                            isMovieSelected = true;
                        } else {
                            System.out.println("ID: " + selectedMovieId + " is not in this category.");
                        }

                    }
                } while (!isMovieSelected);

                System.out.println("Do you want to see details of another movie? [y/N]");
                String input = scanner.nextLine();
                switch (input.toLowerCase()) {
                    case "y", "yes":
                        break;
                    case "n", "no":
                        showDetails = false;
                        break;
                    default:
                        System.out.println("Unknown command.");
                        showDetails = false;
                }
            }
        }
    }

}
