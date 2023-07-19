import java.util.Scanner;

public class KullaniciGirisi {

    public static void main(String[] args) {

        String username, password;

        Scanner input = new Scanner(System.in);

        System.out.println("Kullanıcı adı giriniz: ");
        username = input.nextLine();

        System.out.println("Şifre giriniz: ");
        password = input.nextLine();

        if (username.equalsIgnoreCase("patika")) {
            if (password.equalsIgnoreCase("java123"))
                System.out.println("Giriş yaptınız.");
            else {
                System.out.println("Yeni şifre oluşturunuz: ");
                String newPassword = input.nextLine();
                if (newPassword.equalsIgnoreCase("java123")) {
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                } else {
                    System.out.println("Şifre oluşturuldu.");
                }
            }
        } else {
            System.out.println("Kullanıcı adı yanlış.");
        }
    }
}