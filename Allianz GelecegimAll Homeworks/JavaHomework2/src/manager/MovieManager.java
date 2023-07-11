package manager;

import model.Category;
import model.Movie;
import model.Platform;
import util.PrintHelpUtil;
import util.PrintMoviesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieManager extends BaseManager {

    private PlatformManager platformManager;
    private CategoryManager categoryManager;

    public MovieManager(List<Category> categoryList, List<Platform> platformList,
                        List<Movie> movieList, Scanner scanner, PlatformManager platformManager,
                        CategoryManager categoryManager) {
        super(categoryList, platformList, movieList, scanner);
        this.platformManager = platformManager;
        this.categoryManager = categoryManager;
    }

    public void movieLoop() {
        boolean runMovieLoop = true;
        while (runMovieLoop) {
            System.out.println("""
                    === Movie Manager ===\s
                    1. Print all movies\s
                    2. Add a new movie
                    """);

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "1", "all" -> PrintMoviesUtil.printMovies(movieList, scanner);
                case "2", "new" -> addNewMovieLoop();
                case "h", "help" -> PrintHelpUtil.printMovieHelp();
                case "q", "quit" -> runMovieLoop = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help to see the list of available commands.");
            }
        }
    }

    private void addNewMovieLoop() {
        boolean runNewMovieLoop = true;
        while (runNewMovieLoop) {
            System.out.println("Enter the name of the new movie:");
            String movieName = scanner.nextLine();

            boolean movieExists = movieList.stream()
                    .anyMatch(movie -> movie.getMovieName().equalsIgnoreCase(movieName));
            if (movieExists) {
                System.out.println("A movie with the same name already exists.");
                continue; // Continue to the next iteration of the loop
            }

            System.out.println("Enter the year of the new movie:");
            String year = scanner.nextLine();

            System.out.println("Enter the director's name of the new movie:");
            String director = scanner.nextLine();

            //create the new lists
            List<Platform> newMoviePlatforms = new ArrayList<>();
            List<Category> newMovieCategories = new ArrayList<>();
            List<String> newMovieShowtimes = new ArrayList<>();

            boolean addPlatformsLoop = true, addCategoriesLoop = true, addShowtimesLoop = true;

            System.out.println("Available platforms: ");
            platformManager.printAllPlatforms();
            while (addPlatformsLoop) {

                boolean allOptionsAreAdded = false;

                int platformId;
                boolean isAdded = false;
                do {
                    System.out.println("Enter a platform ID to add: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a valid id!");
                        scanner.next();
                    }
                    platformId = scanner.nextInt();

                    if (platformId <= 0 || platformId > platformList.size()) {
                        System.out.println("Enter a valid id!");
                    } else {
                        scanner.nextLine();

                        Platform addedPlatform = platformManager.getPlatformById(platformId);

                        if (!newMoviePlatforms.contains(addedPlatform)) {
                            newMoviePlatforms.add(addedPlatform);
                            System.out.println("Platform " + addedPlatform.getName() + " added successfully.");
                            isAdded = true;
                        } else {
                            System.out.println("Already added!");
                        }

                        if (newMoviePlatforms.size() == platformList.size()) {
                            System.out.println("No more platforms left to add.");
                            allOptionsAreAdded = true;
                            addPlatformsLoop = false;
                            isAdded = true;
                        }
                    }

                } while (!isAdded);


                if (newMoviePlatforms.size() >= 1 && !allOptionsAreAdded) {
                    System.out.println("Do you want to add another one? [y/N]");
                    String input = scanner.nextLine();
                    switch (input.toLowerCase()) {
                        case "y", "yes":
                            break;
                        case "n", "no":
                            addPlatformsLoop = false;
                            break;
                        default:
                            System.out.println("Unknown command.");
                            addPlatformsLoop = false;
                    }
                }

            }

            System.out.println("Available categories: ");
            categoryManager.printAllCategories();
            while (addCategoriesLoop) {

                boolean allOptionsAreAdded = false;

                int categoriesId;
                boolean isAdded = false;
                do {
                    System.out.println("Enter a category ID to add: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a valid id!");
                        scanner.next();
                    }
                    categoriesId = scanner.nextInt();

                    if (categoriesId <= 0 || categoriesId > categoryList.size()) {
                        System.out.println("Enter a valid id!");
                    } else {
                        scanner.nextLine();

                        Category addedCategory = categoryManager.getCategoryById(categoriesId);

                        if (!newMovieCategories.contains(addedCategory)) {
                            newMovieCategories.add(addedCategory);
                            System.out.println("Category " + addedCategory.getName() + " added successfully.");
                            isAdded = true;
                        } else {
                            System.out.println("Already added!");
                        }

                        if (newMovieCategories.size() == categoryList.size()) {
                            System.out.println("No more categories left to add.");
                            allOptionsAreAdded = true;
                            addCategoriesLoop = false;
                            isAdded = true;
                        }
                    }

                } while (!isAdded);


                if (newMoviePlatforms.size() >= 1 && !allOptionsAreAdded) {
                    System.out.println("Do you want to add another one? [y/N]");
                    String input = scanner.nextLine();
                    switch (input.toLowerCase()) {
                        case "y", "yes":
                            break;
                        case "n", "no":
                            addCategoriesLoop = false;
                            break;
                        default:
                            System.out.println("Unknown command.");
                            addCategoriesLoop = false;
                    }
                }
            }


            while (addShowtimesLoop) {
                System.out.println("Enter a showtime: ");
                String showtime = scanner.nextLine();

                if (!newMovieShowtimes.contains(showtime)) {
                    newMovieShowtimes.add(showtime);
                } else {
                    System.out.println("Already added!");
                }

                if (newMovieShowtimes.size() >= 1) {
                    System.out.println("Do you want to add another one? [y/N]");
                    String input = scanner.nextLine();
                    switch (input.toLowerCase()) {
                        case "y", "yes":
                            break;
                        case "n", "no":
                            addShowtimesLoop = false;
                            break;
                        default:
                            System.out.println("Unknown command.");
                            addShowtimesLoop = false;
                    }
                }
            }

            Movie newMovie = new Movie(movieName, year, director,
                    newMovieCategories, newMoviePlatforms, newMovieShowtimes);
            movieList.add(newMovie);
            categoryManager.updateCategoryMovieCount(newMovieCategories);
            platformManager.updatePlatformMovieCount(newMoviePlatforms);
            System.out.println("Movie " + newMovie.getMovieName() + " added successfully.");

            System.out.println("Do you want to create another movie? [y/N]");
            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "y", "yes":
                    break;
                case "n", "no":
                    runNewMovieLoop = false;
                    break;
                default:
                    System.out.println("Unknown command.");
                    runNewMovieLoop = false;
            }
        }


    }


}
