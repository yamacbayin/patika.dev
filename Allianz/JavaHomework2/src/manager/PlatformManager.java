package manager;

import model.Category;
import model.Movie;
import model.Platform;
import util.PrintHelpUtil;

import java.util.List;
import java.util.Scanner;

public class PlatformManager extends BaseManager {

    public PlatformManager(List<Category> categoryList, List<Platform> platformList,
                       List<Movie> movieList, Scanner scanner) {
        super(categoryList, platformList, movieList, scanner);
    }

    public void platformLoop() {

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

    protected void printAllPlatforms() {
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

    protected Platform getPlatformById(int platformId) {
        for (Platform platform : platformList) {
            if (platform.getId() == platformId) {
                return platform;
            }
        }
        //NPE BABY
        return null;
    }

    protected void updatePlatformMovieCount(List<Platform> newMoviePlatformList) {
        for (Platform newMoviePlatform : newMoviePlatformList) {
            for (Platform platform : platformList) {
                if (platform.getId() == newMoviePlatform.getId()) {
                    platform.incrementMovieCount();
                    break;
                }
            }
        }
    }
}
