import java.util.Scanner;

public class RakamlarToplami {

    public static void main(String[] args) {

        int sayi;
        int toplam = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Rakamları toplanacak sayıyı giriniz:");
        sayi = input.nextInt();

        int temp = sayi;

        while (temp != 0) {
            int basamak = temp % 10;
            toplam += basamak;
            temp /= 10;
        }

        System.out.println(sayi + " sayısının rakamları toplamı: " + toplam);

        input.close();
    }


}