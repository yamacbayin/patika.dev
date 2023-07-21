import java.util.Scanner;

public class ManavKasa {

    public static void main(String[] args) {

        double armutKg, elmaKg, domatesKg, muzKg, patlicanKg;
        double armutFiyat = 2.14;
        double elmaFiyat = 3.67;
        double domatesFiyat = 1.11;
        double muzFiyat = 0.95;
        double patlicanFiyat = 5.00;

        Scanner input = new Scanner(System.in);

        System.out.println("Armut kg giriniz: ");
        armutKg = input.nextDouble();

        System.out.println("Elma kg giriniz: ");
        elmaKg = input.nextDouble();

        System.out.println("Domates kg giriniz: ");
        domatesKg = input.nextDouble();

        System.out.println("Muz kg giriniz: ");
        muzKg = input.nextDouble();

        System.out.println("Patlıcan kg giriniz: ");
        patlicanKg = input.nextDouble();

        System.out.println("Toplam tutar: " + (armutKg * armutFiyat + elmaKg * elmaFiyat +
                domatesKg * domatesFiyat + muzKg * muzFiyat + patlicanKg * patlicanFiyat));

    }
}