import java.util.Scanner;

public class ArtikYil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Yıl Giriniz: ");
        int yil = scanner.nextInt();

        scanner.close();

        if (yil % 100 == 0) {
            if (yil % 400 == 0)
                System.out.println("Artık yıl");
            else
                System.out.println("Artık yıl değil");
        } else {
            if (yil % 4 == 0)
                System.out.println("Artık yıl");
            else
                System.out.println("Artık yıl değil");
        }

    }
}