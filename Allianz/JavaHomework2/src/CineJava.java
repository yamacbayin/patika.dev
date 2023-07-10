import Model.Category;
import Model.Movie;
import Model.Platform;
import Util.PrintHelpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CineJava {
    private List<Category> categoryList;
    private List<Platform> platformList;
    private List<Movie> movieList;
    private boolean isRunning = true;
    private Scanner scanner;

    public CineJava() {
        categoryList = new ArrayList<>();
        platformList = new ArrayList<>();
        movieList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (isRunning) {
            System.out.println("""
                    CineJava Command Line Interface
                    Select user to continue: \s
                    1. Admin\s
                    2. Client""");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "1", "a", "admin" -> adminLoop();
                case "2", "c", "client" -> clientLoop();
                case "h", "help" -> PrintHelpUtil.printHelp();
                case "q", "quit" -> isRunning = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help to see all commands.");
            }
        }
        scanner.close();
    }


    private void adminLoop() {
        boolean runAdminLoop = true;
        while (runAdminLoop) {
            System.out.println("""
                    You are logged in as admin. What do you want to do?\s
                    1. Platform Manager\s
                    2. Category Manager\s
                    3. Movie Manager
                    """);
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "1", "p", "platform" -> platformLoop();
                case "2", "c", "category" -> categoryLoop();
                case "3", "m", "movie" -> movieLoop();
                case "h", "help" -> PrintHelpUtil.printAdminHelp();
                case "q", "quit" -> runAdminLoop = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help for commands list.");
            }
        }
    }

    private void platformLoop() {

        boolean runPlatformLoop = true;
        while (runPlatformLoop) {
            System.out.println("""
                    Platform Manager\s
                    1. Print all platforms\s
                    2. Add a new platform
                    """);

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "1", "all" -> printAllPlatforms();
                case "2", "new" -> addNewPlatformLoop();
                case "h", "help" -> PrintHelpUtil.printPlatformHelp();
                case "q", "quit" -> runPlatformLoop = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help for commands list.");
            }

        }
    }

    private void printAllPlatforms() {
        if (platformList.isEmpty()) {
            System.out.println("There are no platforms in the platform list. Add one to get started. \n");
        } else {
            System.out.println("Printing " + Platform.platformCount + " platforms.");
            for (Platform platform : platformList) {
                System.out.println("ID: " + platform.getId() + ". " + platform.getName()
                        + " - Movie count: " + platform.getMovieCount());
            }
            System.out.println();
        }
    }

    private void addNewPlatformLoop() {
        boolean runNewPlatformLoop = true;
        while (runNewPlatformLoop) {
            System.out.println("Enter the name of the new platform:");
            String name = scanner.nextLine();

            // Check if a platform with the same name already exists
            boolean platformExists = platformList.stream()
                    .anyMatch(platform -> platform.getName().equalsIgnoreCase(name));
            if (platformExists) {
                System.out.println("A platform with the same name already exists.");
                continue; // Continue to the next iteration of the loop
            }

            Platform newPlatform = new Platform(name);
            platformList.add(newPlatform);
            System.out.println("Platform added successfully!");
            System.out.println("Do you want to create another platform? [y/N]");

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "y", "yes":
                    break;
                case "n", "no":
                    runNewPlatformLoop = false;
                    break;
                default:
                    System.out.println("Unknown command.");
                    runNewPlatformLoop = false;
            }
        }
    }

    private void categoryLoop() {

        boolean runCategoryLoop = true;
        while (runCategoryLoop) {
            System.out.println("""
                    Category Manager\s
                    1. Print all categories\s
                    2. Add a new category
                    """);

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "1", "all" -> printAllCategories();
                case "2", "new" -> addNewCategoryLoop();
                case "h", "help" -> PrintHelpUtil.printCategoryHelp();
                case "q", "quit" -> runCategoryLoop = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help for commands list.");
            }
        }
    }


    public void printAllCategories() {

        if (categoryList.isEmpty()) {
            System.out.println("There are no categories in the category list. Add one to get started. \n");
        } else {

            System.out.println("Printing " + Category.categoryCount + " platforms.");
            for (Category category : categoryList) {
                System.out.println("ID: " + category.getId() + ". " + category.getName()
                        + " - Movie count: " + category.getMovieCount());
            }
            System.out.println();

        }
    }

    public void printAllCategoriesWithDetails() {

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
                        printAllMovies(filteredMovies);

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


    private void addNewCategoryLoop() {
        boolean runNewCategoryLoop = true;
        while (runNewCategoryLoop) {
            System.out.println("Enter the name of the new category:");
            String name = scanner.nextLine();

            // Check if a category with the same name already exists
            boolean categoryExists = categoryList.stream()
                    .anyMatch(category -> category.getName().equalsIgnoreCase(name));
            if (categoryExists) {
                System.out.println("A category with the same name already exists.");
                continue; // Continue to the next iteration of the loop
            }

            Category newCategory = new Category(name);
            categoryList.add(newCategory);
            System.out.println("Category added successfully!");
            System.out.println("Do you want to create another category? [y/N]");

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "y", "yes":
                    break;
                case "n", "no":
                    runNewCategoryLoop = false;
                    break;
                default:
                    System.out.println("Unknown command.");
                    runNewCategoryLoop = false;
            }
        }
    }

    private void movieLoop() {
        boolean runMovieLoop = true;
        while (runMovieLoop) {
            System.out.println("""
                    Movie Manager\s
                    1. Print all movies\s
                    2. Add a new movie
                    """);

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "1", "all" -> printAllMovies(movieList);
                case "2", "new" -> addNewMovieLoop();
                case "h", "help" -> PrintHelpUtil.printMovieHelp();
                case "q", "quit" -> runMovieLoop = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help for commands list.");
            }
        }
    }

    public void printAllMovies(List<Movie> listToPrint) {
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
                    case "e", "exit":
                        exit();
                    default:
                        System.out.println("Unknown command.");
                        showDetails = false;
                }
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
            printAllPlatforms();
            while (addPlatformsLoop) {

                boolean allOptionsAreAdded = false;

                int platformId;
                boolean isAdded = false;
                do {
                    System.out.println("Enter a platform's id to add: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a valid id!");
                        scanner.next();
                    }
                    platformId = scanner.nextInt();

                    if (platformId <= 0 || platformId > platformList.size()) {
                        System.out.println("Enter a valid id!");
                    } else {
                        scanner.nextLine();

                        Platform addedPlatform = getPlatformById(platformId);

                        if (!newMoviePlatforms.contains(addedPlatform)) {
                            newMoviePlatforms.add(addedPlatform);
                            System.out.println("Platform " + addedPlatform.getName() + " is added successfully.");
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
            printAllCategories();
            while (addCategoriesLoop) {

                boolean allOptionsAreAdded = false;

                int categoriesId;
                boolean isAdded = false;
                do {
                    System.out.println("Enter a category's id to add: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a valid id!");
                        scanner.next();
                    }
                    categoriesId = scanner.nextInt();

                    if (categoriesId <= 0 || categoriesId > categoryList.size()) {
                        System.out.println("Enter a valid id!");
                    } else {
                        scanner.nextLine();

                        Category addedCategory = getCategoryById(categoriesId);

                        if (!newMovieCategories.contains(addedCategory)) {
                            newMovieCategories.add(addedCategory);
                            System.out.println("Category " + addedCategory.getName() + " is added successfully.");
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
                System.out.println("Enter a showtime data: ");
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
            updateCategoryMovieCount(newMovieCategories);
            updatePlatformMovieCount(newMoviePlatforms);
            System.out.println("Movie " + newMovie.getMovieName() + " is added successfully.");

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

    private void updateCategoryMovieCount(List<Category> newMovieCategoryList) {
        for (Category newMovieCategory : newMovieCategoryList) {
            for (Category category : categoryList) {
                if (category.getId() == newMovieCategory.getId()) {
                    category.incrementMovieCount();
                    break;
                }
            }
        }
    }

    private void updatePlatformMovieCount(List<Platform> newMoviePlatformList) {
        for (Platform newMoviePlatform : newMoviePlatformList) {
            for (Platform platform : platformList) {
                if (platform.getId() == newMoviePlatform.getId()) {
                    platform.incrementMovieCount();
                    break;
                }
            }
        }
    }

    private Category getCategoryById(int categoryId) {
        for (Category category : categoryList) {
            if (category.getId() == categoryId) {
                return category;
            }
        }
        //NPE BABY
        return null;
    }

    private Platform getPlatformById(int platformId) {
        for (Platform platform : platformList) {
            if (platform.getId() == platformId) {
                return platform;
            }
        }
        //NPE BABY
        return null;
    }


    private void clientLoop() {
        boolean runClientLoop = true;
        while (runClientLoop) {
            System.out.println("""
                    You are logged in as client. What do you want to do?\s
                    1. See all movies\s
                    2. See all categories
                    """);

            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "1", "m", "movies" -> printAllMovies(movieList);
                case "2", "c", "categories" -> printAllCategoriesWithDetails();
                case "h", "help" -> PrintHelpUtil.printClientHelp();
                case "q", "quit" -> runClientLoop = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help for commands list.");
            }
        }
    }


    private void exit() {
        scanner.close();
        System.exit(0);
    }
}
