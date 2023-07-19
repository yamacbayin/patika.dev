import java.util.Scanner;

public class Kuvvetler {

    public static void main(String[] args) {

        int n;
        int ikininKati = 1;
        int dordunKati = 1;
        int besinKati = 1;

        Scanner input = new Scanner(System.in);
        System.out.println("Sınır sayısını giriniz:");
        n = input.nextInt();

        while (ikininKati <= n) {
            System.out.println("İkinin katı: " + ikininKati);
            if (dordunKati <= n) {
                System.out.println("Dördün katı: " + dordunKati);
                dordunKati *= 4;
            }
            if (besinKati <= n) {
                System.out.println("Beşin katı: " + besinKati);
                besinKati *= 5;
            }
            ikininKati *= 2;
        }

        input.close();
    }
}