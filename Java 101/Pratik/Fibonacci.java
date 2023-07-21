import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        int number;
        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz: ");
        number = input.nextInt();
        System.out.println(fib(number));
    }

    static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;

        return fib(n - 1) + fib(n - 2);
    }
}