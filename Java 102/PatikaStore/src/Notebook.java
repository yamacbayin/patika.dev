class Notebook extends Product {
    private int storage;
    private double screenSize;
    private int ram;

    public Notebook(String productName, double price, double discount, int stock, String brand,
                    int storage, double screenSize, int ram) {
        super(productName, price, discount, stock, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getRam() {
        return ram;
    }
}