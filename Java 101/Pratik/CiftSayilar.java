import java.util.Scanner;

public class CiftSayilar {

    public static void main(String[] args) {

        int hedef;
        int sayac = 1, uceBolunenToplam = 0, uceBolunenAdet = 0, dordeBolunenToplam = 0, dordeBolunenAdet = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz: ");
        hedef = input.nextInt();

        System.out.println("İkiye tam bölünen sayılar: ");
        while(sayac <= hedef) {

            if (sayac % 2 == 0)
                System.out.println(sayac);

            if(sayac % 3 == 0) {
                uceBolunenAdet++;
                uceBolunenToplam += sayac;
            }
            if(sayac % 4 == 0) {
                dordeBolunenAdet++;
                dordeBolunenToplam += sayac;
            }
            sayac++;
        }

        System.out.println("Üçe bölünebilen sayı adeti " + uceBolunenAdet + ", sayıların toplamı: " + uceBolunenToplam
        + ", ortalaması: " + (uceBolunenToplam / uceBolunenAdet));

        System.out.println("Dörde bölünebilen sayı adeti " + dordeBolunenAdet + ", sayıların toplamı: " + dordeBolunenToplam
                + ", ortalaması: " + (dordeBolunenToplam / dordeBolunenAdet));
        
        input.close();
    }
}