import java.util.Scanner;

public class TekSayilarToplami {

    public static void main(String[] args) {

        int toplam = 0;
        int ciftlerinToplami = 0;
        int dordunKatlariToplami = 0;

        Scanner input = new Scanner(System.in);
        int girdi;
        do {
            System.out.println("Bir sayı giriniz: ");
            girdi = input.nextInt();
            if (girdi < 0)
                continue;
            if (girdi % 2 != 0) {
                toplam += girdi;
            } else {
                ciftlerinToplami += girdi;
                if (girdi % 4 == 0) {
                    dordunKatlariToplami += girdi;
                }
            }
        } while (girdi > 0);

        System.out.println("Tek sayılar toplamı: " + toplam);
        System.out.println("Çift sayılar toplamı: " + ciftlerinToplami);
        System.out.println("Dördün katları toplamı: " + dordunKatlariToplami);

        input.close();
    }
}