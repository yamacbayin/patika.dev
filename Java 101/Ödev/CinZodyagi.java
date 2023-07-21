import java.util.Scanner;

public class CinZodyagi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Doğum Yılınızı Giriniz: ");
        int dogumYili = scanner.nextInt();

        scanner.close();

        int zodyakIndeksi = dogumYili % 12;
        String cinZodyagi = "";

        switch (zodyakIndeksi) {
            case 0 -> cinZodyagi = "Maymun";
            case 1 -> cinZodyagi = "Horoz";
            case 2 -> cinZodyagi = "Köpek";
            case 3 -> cinZodyagi = "Domuz";
            case 4 -> cinZodyagi = "Fare";
            case 5 -> cinZodyagi = "Öküz";
            case 6 -> cinZodyagi = "Kaplan";
            case 7 -> cinZodyagi = "Tavşan";
            case 8 -> cinZodyagi = "Ejderha";
            case 9 -> cinZodyagi = "Yılan";
            case 10 -> cinZodyagi = "At";
            case 11 -> cinZodyagi = "Koyun";
        }

        System.out.println("Çin Zodyağı Burcunuz: " + cinZodyagi);
    }
}