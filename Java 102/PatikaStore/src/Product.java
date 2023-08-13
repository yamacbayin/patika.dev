class Product {
    private static int idCounter = 1;
    private int id;
    private String productName;
    private double price;
    private double discount;
    private int stock;
    private String brand;

    public Product(String productName, double price, double discount, int stock, String brand) {
        this.id = idCounter++;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public String getBrand() {
        return brand;
    }
}