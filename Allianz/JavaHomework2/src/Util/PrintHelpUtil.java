package Util;

public class PrintHelpUtil {
    public static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("1, a, admin - Log in as admin.");
        System.out.println("2, c, client - Log in as client.");
        commonHelp();
    }

    public static void printAdminHelp() {
        System.out.println("Available commands:");
        System.out.println("1, p, platform - Use Platform Manager.");
        System.out.println("2, c, category - Use Category Manager.");
        System.out.println("3, m, movie - Use Movie Manager.");
        commonHelp();
    }

    public static void printPlatformHelp() {
        System.out.println("Available commands:");
        System.out.println("1, all - Print all platforms");
        System.out.println("2, new - Add a new platform");
        commonHelp();
    }

    public static void printCategoryHelp() {
        System.out.println("Available commands:");
        System.out.println("1, all - Print all categories");
        System.out.println("2, new - Add a new category");
        commonHelp();
    }

    public static void printMovieHelp() {
        System.out.println("Available commands:");
        System.out.println("1, all - Print all movies");
        System.out.println("2, new - Add a new movie");
        commonHelp();
    }

    public static void printClientHelp() {
        System.out.println("Available commands:");
        System.out.println("1, m, movies - Print all movies.");
        System.out.println("2, c, categories - Print all categories.");
        commonHelp();
    }

    private static void commonHelp() {
        System.out.println("q, quit - Quit your current process and go up one level.");
        System.out.println("e, exit - Exit the program.");
        System.out.println();
    }
}
