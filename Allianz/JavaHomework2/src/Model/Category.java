package Model;

import java.util.Objects;

public class Category {

    public static int categoryCount = 0;

    private int id;
    private String name;

    private int movieCount;


    public Category(String name) {
        this.id = ++categoryCount;
        this.name = name;
    }

    public void incrementMovieCount() {
        this.movieCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(int movieCount) {
        this.movieCount = movieCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return getId() == category.getId() && getMovieCount() == category.getMovieCount() && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMovieCount());
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movieCount=" + movieCount +
                '}';
    }
}
