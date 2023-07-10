package manager;

import model.Category;
import model.Movie;
import model.Platform;
import util.PrintHelpUtil;

import java.util.List;
import java.util.Scanner;

public class CategoryManager extends BaseManager {

    public CategoryManager(List<Category> categoryList, List<Platform> platformList,
                           List<Movie> movieList, Scanner scanner) {
        super(categoryList, platformList, movieList, scanner);
    }

    public void categoryLoop() {

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

    protected void printAllCategories() {

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

    public Category getCategoryById(int categoryId) {
        for (Category category : categoryList) {
            if (category.getId() == categoryId) {
                return category;
            }
        }
        //NPE BABY
        return null;
    }

    protected void updateCategoryMovieCount(List<Category> newMovieCategoryList) {
        for (Category newMovieCategory : newMovieCategoryList) {
            for (Category category : categoryList) {
                if (category.getId() == newMovieCategory.getId()) {
                    category.incrementMovieCount();
                    break;
                }
            }
        }
    }




}
