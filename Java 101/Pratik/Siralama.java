import java.util.Arrays;
import java.util.Scanner;

public class Siralama {

    public static void main(String[] args) {

        int a, b, c;

        Scanner input = new Scanner(System.in);

        System.out.println("İlk sayıyı giriniz: ");
        a = input.nextInt();

        System.out.println("İkinci sayıyı giriniz: ");
        b = input.nextInt();

        System.out.println("Üçüncü sayıyı giriniz: ");
        c = input.nextInt();

        int[] array = {a, b, c};
        Arrays.sort(array);
        System.out.println("Sıralanmış sayılar: ");
        System.out.println(Arrays.toString(array));
    }
}