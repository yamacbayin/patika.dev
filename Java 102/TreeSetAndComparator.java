import java.util.*;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Ba", 24);
        Book book2 = new Book("Ab", 124);
        Book book3 = new Book("Aa", 624);
        Book book4 = new Book("BA", 524);
        Book book5 = new Book("Cc", 24);

        Set<Book> bookSet = new TreeSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        System.out.println(bookSet);

        TreeSet<Book> pageSortedSet = new TreeSet<>(new BookComparator());
        pageSortedSet.addAll(bookSet);
        System.out.println(pageSortedSet);
        
    }


}

public class Book implements Comparable<Book> {

    private String name;
    private int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }


    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }
}

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPages() - o2.getPages();
    }
}
