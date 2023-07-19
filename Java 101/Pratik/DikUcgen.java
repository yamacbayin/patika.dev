import java.util.Scanner;

public class DikUcgen {

    public static void main(String[] args) {

        int a, b;
        double c;
        Scanner input = new Scanner(System.in);

        System.out.println("İlk kenarı giriniz: ");
        a = input.nextInt();
        input.nextLine();
        System.out.println("İkinci kenarı giriniz: ");
        b = input.nextInt();

        c = Math.sqrt((a * a) + (b * b));

        System.out.println("Hipotenüs uzunluğu: " + c);

        double cevre = (a + b + c) / 2;
        System.out.println("Üçgenin çevresi: " + cevre);

        double alan =  Math.sqrt(cevre * (cevre - a) * (cevre - b) * (cevre - c));
        System.out.println("Üçgenin alanı: " + alan);

    }
}