import java.util.Scanner;

public class HesapMakinesi {

    public static void main(String[] args) {

        int n1, n2;

        Scanner input = new Scanner(System.in);

        System.out.println("İlk sayıyı giriniz: ");
        n1 = input.nextInt();

        System.out.println("İkinci sayıyı giriniz: ");
        n2 = input.nextInt();

        System.out.println("İşlem seçiniz");
        System.out.println("1. Toplama\n2. Çıkarma\n3. Çarpma\n4. Bölme");
        int secim = input.nextInt();

        switch (secim) {
            case 1 -> System.out.println("Sayıların toplamı: " + (n1 + n2));
            case 2 -> System.out.println("Sayıların farkı: " + (n1 - n2));
            case 3 -> System.out.println("Sayıların çarpımı: " + (n1 * n2));
            case 4 -> {
                if (n2 != 0)
                    System.out.println("Sayıların bölümü: " + (n1 / n2));
                else
                    System.out.println("Sıfıra bölünemez.");
            }
            default -> System.out.println("Hatalı seçim yaptınız.");
        }
    }
}