package Model;

import java.util.List;

public class Movie {

    public static int movieCount = 0;

    private int movieId;
    private String movieName;
    private String movieYear;
    private String director;
    private List<Category> movieCategoryList;
    private List<Platform> moviePlatformList;
    private List<String> movieShowtimeList;

    public  Movie(String movieName, String movieYear, String director, List<Category> movieCategoryList,
                  List<Platform> moviePlatformList, List<String> movieShowtimeList) {
        this.movieId = ++movieCount;
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.director = director;
        this.movieCategoryList = movieCategoryList;
        this.moviePlatformList = moviePlatformList;
        this.movieShowtimeList = movieShowtimeList;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Category> getMovieCategoryList() {
        return movieCategoryList;
    }

    public void setMovieCategoryList(List<Category> movieCategoryList) {
        this.movieCategoryList = movieCategoryList;
    }

    public List<Platform> getMoviePlatformList() {
        return moviePlatformList;
    }

    public void setMoviePlatformList(List<Platform> moviePlatformList) {
        this.moviePlatformList = moviePlatformList;
    }

    public List<String> getMovieShowtimeList() {
        return movieShowtimeList;
    }

    public void setMovieShowtimeList(List<String> movieShowtimeList) {
        this.movieShowtimeList = movieShowtimeList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieYear='" + movieYear + '\'' +
                ", director='" + director + '\'' +
                ", movieCategoryList=" + movieCategoryList +
                ", moviePlatformList=" + moviePlatformList +
                ", movieShowtimeList=" + movieShowtimeList +
                '}';
    }
}
