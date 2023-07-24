import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Fighter marc = new Fighter("Marc", 15, 100, 90, 10);
        Fighter alex = new Fighter("Alex", 15, 100, 100, 10);
        Ring r = new Ring(marc, alex, 90, 100);
        r.run();

    }
}