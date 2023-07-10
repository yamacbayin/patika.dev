package module;

import model.Category;
import model.Movie;
import model.Platform;
import util.PrintHelpUtil;
import util.PrintMoviesUtil;

import java.util.List;
import java.util.Scanner;

public class ClientModule extends BaseModule {

    public ClientModule(List<Category> categoryList, List<Platform> platformList,
                        List<Movie> movieList, Scanner scanner) {
        super(categoryList, platformList, movieList, scanner);
    }

    public void clientLoop() {
        boolean runClientLoop = true;
        while (runClientLoop) {
            System.out.println("""
                    You are logged in as client. What do you want to do?\s
                    1. See all movies\s
                    2. See all categories
                    """);

            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "1", "m", "movies" -> PrintMoviesUtil.printMovies(movieList, scanner);
                case "2", "c", "categories" -> printAllCategoriesWithDetails();
                case "h", "help" -> PrintHelpUtil.printClientHelp();
                case "q", "quit" -> runClientLoop = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help for commands list.");
            }
        }
    }

    private void printAllCategoriesWithDetails() {

        if (categoryList.isEmpty()) {
            System.out.println("There are no categories in the category list. Add one to get started. \n");
        } else {

            System.out.println("Printing " + Category.categoryCount + " platforms.");
            for (Category category : categoryList) {
                System.out.println("ID: " + category.getId() + ". " + category.getName()
                        + " - Movie count: " + category.getMovieCount());
            }
            System.out.println();

            boolean showDetails = true;
            while (showDetails) {

                boolean isCategorySelected = false;

                int selectedId;

                do {
                    System.out.println("Enter a category's id to see it's movies: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a valid id!");
                        scanner.next();
                    }
                    selectedId = scanner.nextInt();

                    if (selectedId <= 0 || selectedId > categoryList.size()) {
                        System.out.println("Enter a valid id!");
                    } else {
                        scanner.nextLine();

                        int finalSelectedId = selectedId;
                        List<Movie> filteredMovies = movieList.stream()
                                .filter(movie -> movie.getMovieCategoryList().stream()
                                        .anyMatch(category -> category.getId() == finalSelectedId))
                                .toList();
                        PrintMoviesUtil.printMovies(filteredMovies, scanner);

                        isCategorySelected = true;
                    }
                } while (!isCategorySelected);

                System.out.println("Do you want to see details of another category? [y/N]");
                String input = scanner.nextLine();
                switch (input.toLowerCase()) {
                    case "y", "yes":
                        break;
                    case "n", "no":
                        showDetails = false;
                        break;
                    case "e", "exit":
                        exit();
                    default:
                        System.out.println("Unknown command.");
                        showDetails = false;
                }
            }
        }
    }
}
