import java.util.Scanner;

public class Taksimetre {

    public static void main(String[] args) {

        double gidilecekKm;
        double taksimetreTutar;
        double taksimetreKmFiyat = 2.20;
        double acilisUcreti = 10;
        double minimumTutar = 20;

        Scanner input = new Scanner(System.in);

        System.out.println("Gidilecek yolu kilometre olarak giriniz: ");
        gidilecekKm = input.nextDouble();

        taksimetreTutar = gidilecekKm * taksimetreKmFiyat;

        double toplamTutar = acilisUcreti + taksimetreTutar;

        if (toplamTutar < minimumTutar) {
            System.out.println("Minimum tutar olan 20 TL ödenmelidir.");
        } else {
            System.out.println("Ödenecek tutar: " + toplamTutar + " TL.");
        }

    }
}