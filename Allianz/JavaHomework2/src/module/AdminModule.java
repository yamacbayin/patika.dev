package module;

import model.Category;
import model.Movie;
import model.Platform;
import manager.CategoryManager;
import manager.MovieManager;
import manager.PlatformManager;
import util.PrintHelpUtil;

import java.util.List;
import java.util.Scanner;

public class AdminModule extends BaseModule {
    private PlatformManager platformManager;
    private CategoryManager categoryManager;
    private MovieManager movieManager;

    public AdminModule(List<Category> categoryList, List<Platform> platformList,
                       List<Movie> movieList, Scanner scanner) {
        super(categoryList, platformList, movieList, scanner);
        platformManager = new PlatformManager(categoryList, platformList, movieList, scanner);
        categoryManager = new CategoryManager(categoryList, platformList, movieList, scanner);
        movieManager = new MovieManager(categoryList, platformList, movieList,
                scanner, platformManager, categoryManager);
    }

    public void adminLoop() {
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
                case "1", "p", "platform" -> platformManager.platformLoop();
                case "2", "c", "category" -> categoryManager.categoryLoop();
                case "3", "m", "movie" -> movieManager.movieLoop();
                case "h", "help" -> PrintHelpUtil.printAdminHelp();
                case "q", "quit" -> runAdminLoop = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help for commands list.");
            }
        }
    }

}
