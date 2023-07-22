import java.util.Scanner;

public class Desen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayı Giriniz: ");
        int n = scanner.nextInt();

        desen(n, n, true);

        scanner.close();

    }

    public static void desen(int n, int sayiGuncelDeger, boolean asagiDogru) {
        if(sayiGuncelDeger == n && asagiDogru) {
            System.out.print(sayiGuncelDeger + " ");
        }
        if(sayiGuncelDeger == n && !asagiDogru) {
            return;
        }
        if (sayiGuncelDeger <= 0) {
            asagiDogru = false;
        }
        if(asagiDogru) {
            sayiGuncelDeger -= 5;
        } else {
            sayiGuncelDeger += 5;
        }

        System.out.print(sayiGuncelDeger + " ");
        desen(n, sayiGuncelDeger, asagiDogru);

    }
}