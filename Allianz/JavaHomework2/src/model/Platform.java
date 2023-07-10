package model;

import java.util.Objects;

public class Platform {
    public static int platformCount = 0;

    private int id;
    private String name;
    private int movieCount;

   public Platform(String name) {
        this.id = ++platformCount;
        this.name = name;
    }

    public void incrementMovieCount() {
       this.movieCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Platform platform = (Platform) o;
        return getId() == platform.getId() && getMovieCount() == platform.getMovieCount() && Objects.equals(getName(), platform.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMovieCount());
    }

    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movieCount=" + movieCount +
                '}';
    }
}
