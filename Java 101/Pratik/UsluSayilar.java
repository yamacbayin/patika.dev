import java.util.Scanner;

public class UsluSayilar {

    public static void main(String[] args) {

        int taban;
        int us;

        Scanner input = new Scanner(System.in);
        System.out.println("Taban sayısını giriniz:");
        taban = input.nextInt();

        System.out.println("Üs sayısını giriniz:");
        us = input.nextInt();

        int kuvvet = 1;
        for (int i = 0; i <= us; i++){
            System.out.println(taban + " sayısının " + i + ". kuvveti: ");
            if (i == 0) {
                System.out.println(1);
                continue;
            }
            kuvvet *= taban;
            System.out.println(kuvvet);
        }

        input.close();
    }
}