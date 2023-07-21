import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args) {

        String number;
        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz: ");
        number = input.next();

        String s = String.valueOf(number);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        if (s.equalsIgnoreCase(sb.toString())) {
            System.out.println("Palindrom");
        } else {
            System.out.println("Palindrom değil");
        }

    }
}