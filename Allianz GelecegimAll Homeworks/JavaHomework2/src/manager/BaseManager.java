package manager;

import model.Category;
import model.Movie;
import model.Platform;

import java.util.List;
import java.util.Scanner;

public class BaseManager {

    protected List<Category> categoryList;
    protected List<Platform> platformList;
    protected List<Movie> movieList;
    protected Scanner scanner;

    public BaseManager(List<Category> categoryList, List<Platform> platformList,
                       List<Movie> movieList, Scanner scanner) {
        this.categoryList = categoryList;
        this.platformList = platformList;
        this.movieList = movieList;
        this.scanner = scanner;
    }

    protected void exit() {
        scanner.close();
        System.exit(0);
    }



}
