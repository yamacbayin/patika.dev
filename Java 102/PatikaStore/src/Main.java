import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> brands = new ArrayList<>(Arrays.asList(
                "Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"
        ));

        List<Phone> phones = new ArrayList<>();
        List<Notebook> notebooks = new ArrayList<>();

        while (true) {
            System.out.println("\nPatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Çıkış yapılıyor...");
                break;
            } else if (choice == 1) {
                handleNotebookOperations(scanner, notebooks, brands);
            } else if (choice == 2) {
                handlePhoneOperations(scanner, phones, brands);
            } else if (choice == 3) {
                listBrands(brands);
            } else {
                System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }
    }

    public static void handleNotebookOperations(Scanner scanner, List<Notebook> notebooks, List<String> brands) {
        System.out.println("Notebook İşlemleri");
        System.out.println("1 - Notebook Ekle");
        System.out.println("2 - Notebook Sil");
        System.out.println("3 - Notebook Listele");
        System.out.print("Tercihiniz : ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            addNotebook(scanner, notebooks, brands);
        } else if (choice == 2) {
            deleteProduct(scanner, notebooks);
        } else if (choice == 3) {
            listProducts(notebooks);
        } else {
            System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
        }
    }

    public static void handlePhoneOperations(Scanner scanner, List<Phone> phones, List<String> brands) {
        System.out.println("Cep Telefonu İşlemleri");
        System.out.println("1 - Cep Telefonu Ekle");
        System.out.println("2 - Cep Telefonu Sil");
        System.out.println("3 - Cep Telefonu Listele");
        System.out.print("Tercihiniz : ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            addPhone(scanner, phones, brands);
        } else if (choice == 2) {
            deleteProduct(scanner, phones);
        } else if (choice == 3) {
            listProducts(phones);
        } else {
            System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
        }
    }

    public static void listBrands(List<String> brands) {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        Collections.sort(brands);
        for (String brand : brands) {
            System.out.println("- " + brand);
        }
    }

    public static void addNotebook(Scanner scanner, List<Notebook> notebooks, List<String> brands) {
        System.out.print("Ürün adı: ");
        String productName = scanner.next();
        System.out.print("Birim fiyatı: ");
        double price = scanner.nextDouble();
        System.out.print("İndirim oranı: ");
        double discount = scanner.nextDouble();
        System.out.print("Stok miktarı: ");
        int stock = scanner.nextInt();
        System.out.print("Marka: ");
        String brand = scanner.next();
        if (!brands.contains(brand)) {
            System.out.println("Geçersiz marka. Lütfen sistemde ekli olan bir marka seçin.");
            return;
        }
        System.out.print("RAM: ");
        int ram = scanner.nextInt();
        System.out.print("Depolama: ");
        int storage = scanner.nextInt();
        System.out.print("Ekran Boyutu: ");
        double screenSize = scanner.nextDouble();

        Notebook notebook = new Notebook(productName, price, discount, stock, brand, storage, screenSize, ram);
        notebooks.add(notebook);

        System.out.println("Notebook başarıyla eklendi.");
    }

    public static void addPhone(Scanner scanner, List<Phone> phones, List<String> brands) {
        System.out.print("Ürün adı: ");
        String productName = scanner.next();
        System.out.print("Birim fiyatı: ");
        double price = scanner.nextDouble();
        System.out.print("İndirim oranı: ");
        double discount = scanner.nextDouble();
        System.out.print("Stok miktarı: ");
        int stock = scanner.nextInt();
        System.out.print("Marka: ");
        String brand = scanner.next();
        if (!brands.contains(brand)) {
            System.out.println("Geçersiz marka. Lütfen sistemde ekli olan bir marka seçin.");
            return;
        }
        System.out.print("Telefonun hafıza bilgisi: ");
        String memory = scanner.next();
        System.out.print("Ekran Boyutu: ");
        double screenSize = scanner.nextDouble();
        System.out.print("Pil Gücü: ");
        double batteryPower = scanner.nextDouble();
        System.out.print("RAM: ");
        int ram = scanner.nextInt();
        System.out.print("Renk: ");
        String color = scanner.next();

        Phone phone = new Phone(productName, price, discount, stock, brand, memory, screenSize, batteryPower, ram, color);
        phones.add(phone);

        System.out.println("Cep telefonu başarıyla eklendi.");
    }

    public static void deleteProduct(Scanner scanner, List<? extends Product> products) {
        System.out.print("Silmek istediğiniz ürünün ID'sini girin: ");
        int id = scanner.nextInt();
        Product productToRemove = null;

        for (Product product : products) {
            if (product.getId() == id) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Ürün başarıyla silindi.");
        } else {
            System.out.println("Belirtilen ID'ye sahip bir ürün bulunamadı.");
        }
    }

    public static void listProducts(List<? extends Product> products) {
        if (products.isEmpty()) {
            System.out.println("Listelenecek ürün bulunmamaktadır.");
            return;
        }

        if (products.get(0) instanceof Phone) {
            System.out.println("\nCep Telefonu Listesi\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            for (Phone phone : (List<Phone>) products) {
                System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-9s | %-9.1f | %-9d | %-9.1f | %-9d | %-9s |\n",
                        phone.getId(), phone.getProductName(), phone.getPrice(), phone.getBrand(), phone.getMemory(),
                        phone.getScreenSize(), phone.getCamera(), phone.getBatteryPower(), phone.getRam(), phone.getColor());
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        } else if (products.get(0) instanceof Notebook) {
            System.out.println("\nNotebook Listesi\n");
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (Notebook notebook : (List<Notebook>) products) {
                System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-9s | %-9.1f | %-9d |\n",
                        notebook.getId(), notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                        notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Bilinmeyen ürün türü.");
        }
    }
}