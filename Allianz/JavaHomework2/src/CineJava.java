import model.Category;
import model.Movie;
import model.Platform;
import module.ClientModule;
import util.PrintHelpUtil;
import module.AdminModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CineJava {
    private List<Category> categoryList;
    private List<Platform> platformList;
    private List<Movie> movieList;
    private boolean isRunning = true;
    private Scanner scanner;

    private AdminModule adminModule;
    private ClientModule clientModule;

    public CineJava() {
        categoryList = new ArrayList<>();
        platformList = new ArrayList<>();
        movieList = new ArrayList<>();
        scanner = new Scanner(System.in);
        adminModule = new AdminModule(categoryList, platformList, movieList, scanner);
        clientModule = new ClientModule(categoryList, platformList, movieList, scanner);
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
                case "1", "a", "admin" -> adminModule.adminLoop();
                case "2", "c", "client" -> clientModule.clientLoop();
                case "h", "help" -> PrintHelpUtil.printHelp();
                case "q", "quit" -> isRunning = false;
                case "e", "exit" -> exit();
                default -> System.out.println("Unknown command. Type help to see all commands.");
            }
        }
        scanner.close();
    }

    private void exit() {
        scanner.close();
        System.exit(0);
    }
}
