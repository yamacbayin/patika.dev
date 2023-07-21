import java.util.Scanner;

public class UcakBileti {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mesafeyi (KM) giriniz: ");
        int mesafe = scanner.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        int yas = scanner.nextInt();

        System.out.print("Yolculuk tipini seçiniz (Tek Yön için 1, Gidiş-Dönüş için 2): ");
        int yolculukTipi = scanner.nextInt();

        scanner.close();

        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
            return;
        }

        double birimUcret = 0.10;

        double toplamUcret = mesafe * birimUcret;

        if (yas < 12) {
            toplamUcret *= 0.5;
        } else if (yas <= 24) {
            toplamUcret *= 0.9;
        } else if (yas >= 65) {
            toplamUcret *= 0.7;
        }

        if (yolculukTipi == 2) {
            toplamUcret *= 1.6;
        }

        System.out.println("Toplam Tutar: " + toplamUcret + " TL");
    }
}