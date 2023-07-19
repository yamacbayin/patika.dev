import java.util.Scanner;

public class Etkinlik {

    public static void main(String[] args) {

        int heat;

        Scanner input = new Scanner(System.in);

        System.out.println("Sıcaklık giriniz: ");
        heat = input.nextInt();

        if (heat < 5) {
            System.out.println("Kayak yapabilirsiniz.");
        } else if (heat <= 15) {
            System.out.println("Sinema");
        } else if (heat <= 25) {
            System.out.println("Piknik");
        } else {
            System.out.println("Yüzme");
        }
    }
}