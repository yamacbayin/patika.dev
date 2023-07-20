import java.util.Scanner;
import java.util.stream.IntStream;

public class YildizElmas {

    public static void main(String[] args) {

        int n;

        Scanner input = new Scanner(System.in);
        System.out.println("Bir sayı giriniz:");
        n = input.nextInt();


        IntStream.rangeClosed(0, n).forEach(i -> {
            System.out.printf("%" + (n - i + 1) + "s", "");
            System.out.println("*".repeat(2 * i + 1));
        });

        IntStream.rangeClosed(0, n - 1).forEach(i -> {
            System.out.printf("%" + (i + 2) + "s", "");
            System.out.println("*".repeat(2 * (n - i - 1) + 1));
        });

        input.close();
    }
}