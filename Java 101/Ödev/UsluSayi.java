import java.util.Scanner;

public class UsluSayi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Taban Değeri Giriniz: ");
        int t = scanner.nextInt();

        System.out.print("Üs Değeri Giriniz: ");
        int u = scanner.nextInt();

        scanner.close();

        int sonuc = usHesapla(t, u, 1);
        System.out.println(sonuc);

    }

    public static int usHesapla(int t, int u, int acc) {
        if (u == 0)
            return acc;

        return usHesapla(t, u - 1, t * acc);
    }
}