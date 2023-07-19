import java.util.Scanner;

public class KdvHesaplama {

    public static void main(String[] args) {

        double kdvsizFiyat, kdvTutar, kdvliFiyat;
        double kdvYuzde18 = 0.18;
        double kdvYuzde8 = 0.08;

        Scanner input = new Scanner(System.in);

        System.out.println("KDV'siz fiyat: ");
        kdvsizFiyat = input.nextDouble();

        if (kdvsizFiyat < 1000) {
            kdvTutar = kdvsizFiyat * kdvYuzde18;
            kdvliFiyat = kdvsizFiyat * 1.18;
        } else {
            kdvTutar = kdvsizFiyat * kdvYuzde8;
            kdvliFiyat = kdvsizFiyat * 1.08;
        }

        System.out.println("KDV tutarı: " + kdvTutar);
        System.out.println("KDV'li fiyat: " + kdvliFiyat);

    }
}