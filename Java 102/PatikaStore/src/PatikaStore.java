import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PatikaStore {

    private static List<Brand> brandList = new ArrayList<>();

    static {
        String[] brandNames = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};

        for (int i = 0; i < brandNames.length; i++) {
            Brand brand = new Brand((i + 1), brandNames[i]);
            brandList.add(brand);
        }

        brandList.sort(Comparator.naturalOrder());
    }

    public static List<Brand> getBrandList() {
        return brandList;
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ürünleri Listele");
            System.out.println("2. Ürün Ekle");
            System.out.println("3. Ürün Sil");
            System.out.println("4. Ürün Filtrele (Benzersiz No)");
            System.out.println("5. Ürünleri Markaya Göre Filtrele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Dummy read to consume the newline

            switch (choice) {
                case 1:
                    system.listProducts();
                    break;
                case 2:
                    System.out.print("Ürün Adı: ");
                    String productName = scanner.nextLine();
                    System.out.print("Birim Fiyatı: ");
                    double unitPrice = scanner.nextDouble();
                    scanner.nextLine(); // Dummy read to consume the newline
                    System.out.print("Marka: ");
                    String brandName = scanner.nextLine();
                    Brand brand = new Brand(brandName);
                    System.out.print("Benzersiz No: ");
                    int productNumber = scanner.nextInt();
                    scanner.nextLine(); // Dummy read to consume the newline

                    Product newProduct = new Product(productNumber, unitPrice, productName, brand);
                    system.addProduct(newProduct);
                    break;
                case 3:
                    System.out.print("Silinecek Ürünün Benz. No: ");
                    int deleteProductNumber = scanner.nextInt();
                    scanner.nextLine(); // Dummy read to consume the newline
                    system.removeProduct(deleteProductNumber);
                    break;
                case 4:
                    System.out.print("Filtrelenecek Ürünün Benz. No: ");
                    int filterProductNumber = scanner.nextInt();
                    scanner.nextLine(); // Dummy read to consume the newline
                    system.filterByProductNumber(filterProductNumber);
                    break;
                case 5:
                    System.out.print("Filtrelenecek Marka: ");
                    String filterBrand = scanner.nextLine();
                    system.filterByBrand(filterBrand);
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim.");
            }
        }

    }

}
