import java.util.Scanner;

public class NotOrtalamasi {

    public static void main(String[] args) {
        int mat, fizik, kimya, turkce, tarih, muzik;

        Scanner input = new Scanner(System.in);

        System.out.println("Matematik notunuz: ");
        mat = input.nextInt();

        System.out.println("Fizik notunuz: ");
        fizik = input.nextInt();

        System.out.println("Kimya notunuz: ");
        kimya = input.nextInt();

        System.out.println("Türkçe notunuz: ");
        turkce = input.nextInt();

        System.out.println("Tarih notunuz: ");
        tarih = input.nextInt();

        System.out.println("Müzik notunuz: ");
        muzik = input.nextInt();

        double sonuc = (mat + fizik + kimya + turkce + tarih + muzik) / 6.0;
        System.out.println("Ortalamanız: " + sonuc);

        if(sonuc > 60) {
            System.out.println("Sınıfı geçti");
        } else {
            System.out.println("Sınıfta kaldı.");
        }
    }
}