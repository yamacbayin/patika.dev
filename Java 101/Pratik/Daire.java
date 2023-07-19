import java.util.Scanner;

public class Daire {

    public static void main(String[] args) {

        double r;
        double alan;
        double cevre;
        double 𝛼;
        double dilimAlan;

        Scanner input = new Scanner(System.in);

        System.out.println("Yarı çap giriniz: ");
        r = input.nextDouble();

        alan = Math.PI * r * r;
        System.out.println("Dairenin alanı: " + alan);
        cevre = 2 * Math.PI * r;
        System.out.println("Dairenin çevresi: " + cevre);

        System.out.println("Açı giriniz: ");
        𝛼 = input.nextDouble();

        dilimAlan = (Math.PI * (r *r) * 𝛼) / 360;

        System.out.println("Dairenin " + 𝛼 + " açılık diliminin alanı: " + dilimAlan);

    }
}