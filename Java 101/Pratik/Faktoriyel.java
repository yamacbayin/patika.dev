import java.util.Scanner;

public class Faktoriyel {

    public static void main(String[] args) {

        int n;
        int r;

        Scanner input = new Scanner(System.in);
        System.out.println("Küme eleman sayısını giriniz:");
        n = input.nextInt();

        System.out.println("Alt küme eleman sayısını giriniz:");
        r = input.nextInt();

        System.out.println(n +" elemanlı bir kümenin " + r + " elemanlı alt kümelerinin kombinasyonu: ");
        int kombinasyon = faktoriyel(n, 1) / (faktoriyel(r, 1) * faktoriyel(n - r, 1));
        System.out.println(kombinasyon);

        input.close();
    }

    public static int faktoriyel(int n, int toplam) {
        if (n == 1)
            return toplam;
        else
            return faktoriyel(n - 1, toplam * n);
    }
}