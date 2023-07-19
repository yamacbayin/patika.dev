import java.util.Scanner;

public class Burc {

    public static void main(String[] args) {

        int ay, gun;

        Scanner input = new Scanner(System.in);

        System.out.println("Doğduğunuz ayı giriniz: ");
        ay = input.nextInt();


        System.out.println("Doğduğunuz günü giriniz: ");
        gun = input.nextInt();

        String burc = null;

        if (gun < 1 || gun > 31) {
            System.out.println("Hatalı giriş yaptınız.");
            System.exit(0);
        }

        if (ay == 1) {
            burc = gun <= 21 ? "Oğlak" : "Kova";
        } else if (ay == 2) {
            burc = gun <= 19 ? "Kova" : "Balık";
        } else if (ay == 3) {
            burc = gun <= 20 ? "Balık" : "Koç";
        } else if (ay == 4) {
            burc = gun <= 20 ? "Koç" : "Boğa";
        } else if (ay == 5) {
            burc = gun <= 21 ? "Boğa" : "İkizler";
        } else if (ay == 6) {
            burc = gun <= 22 ? "İkizler" : "Yengeç";
        } else if (ay == 7) {
            burc = gun <= 22 ? "Yengeç" : "Aslan";
        } else if (ay == 8) {
            burc = gun <= 22 ? "Aslan" : "Başak";
        } else if (ay == 9) {
            burc = gun <= 22 ? "Başak" : "Terazi";
        } else if (ay == 10) {
            burc = gun <= 22 ? "Teraz," : "Akrep";
        } else if (ay == 11) {
            burc = gun <= 21 ? "Akrep" : "Yay";
        } else if (ay == 12) {
            burc = gun <= 21 ? "Yay" : "Oğlak";
        } else {
            System.out.println("Hatalı giriş yaptınız.");
        }

        if (burc != null)
            System.out.println("Burcunuz: " + burc);

    }
}