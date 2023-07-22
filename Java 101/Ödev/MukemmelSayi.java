import java.util.ArrayList;
import java.util.Scanner;

public class MukemmelSayi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayı Giriniz: ");
        int n = scanner.nextInt();

        scanner.close();

        ArrayList<Integer> carpanlar = carpanlariBul(n, n - 1, new ArrayList<Integer>());
        System.out.println("Çarpanlar: " + carpanlar);

        int toplam = carpanlar.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Çarpanlar toplamı:" + toplam);

        if (n == toplam)
            System.out.println("Mükemmel sayıdır.");
        else
            System.out.println("Mükemmel sayı değildir.");

    }

    public static ArrayList<Integer> carpanlariBul(int n, int bolen, ArrayList<Integer> list) {
        if (n == 1) {
            return list;
        }
        if (bolen == 1) {
            list.add(1);
            return list;
        }
        if (n % bolen == 0) {
            list.add(bolen);
        }

        return carpanlariBul(n, bolen - 1, list);
    }
}