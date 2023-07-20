import java.util.Scanner;

public class HarmonikSeri {

    public static void main(String[] args) {

        int n;
        double toplam = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Harmonik serisi bulunacak sayıyı giriniz:");
        n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            toplam += (double) 1 / i;
        }

        System.out.println("Sonuç: " + toplam);

        input.close();
    }


}