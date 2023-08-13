class Phone extends Product {
    private String memory;
    private double screenSize;
    private int camera;
    private double batteryPower;
    private int ram;
    private String color;

    public Phone(String productName, double price, double discount, int stock, String brand,
                 String memory, double screenSize, double batteryPower, int ram, String color) {
        super(productName, price, discount, stock, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.camera = camera;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    public String getMemory() {
        return memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getCamera() {
        return camera;
    }

    public double getBatteryPower() {
        return batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }
}