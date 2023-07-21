import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayı Giriniz: ");
        int n = scanner.nextInt();

        scanner.close();

        int sol = 1;
        int sag = 0;
        int temp;

        while (n >= 0) {
            System.out.print(sag + " ");
            temp = sol + sag;
            sol = sag;
            sag = temp;
            n--;
        }
    }
}