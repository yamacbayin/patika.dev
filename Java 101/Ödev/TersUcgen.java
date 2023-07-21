import java.util.Scanner;

public class TersUcgen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Basamak Sayısı Giriniz: ");
        int n = scanner.nextInt();

        scanner.close();

        for (int i = 0; i < n; i++) {
            System.out.printf("%" + (i + 1) + "s", "");
            System.out.print("*" .repeat((2 * n) - (2 * i) - 1));
            System.out.println();
        }

    }
}