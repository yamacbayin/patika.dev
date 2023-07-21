import java.util.Scanner;

public class VucutKitleIndeksi {

    public static void main(String[] args) {

        double boy;
        double kilo;
        Scanner input = new Scanner(System.in);

        System.out.println("Boyunuzu giriniz: ");
        boy = input.nextDouble();

        System.out.println("Kilonuzu giriniz: ");
        kilo = input.nextDouble();

        double indeks = kilo / (boy * boy);
        System.out.println("Vücut kitle indeksiniz: " + indeks);
    }
}