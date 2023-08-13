import java.util.Date;

class CarInsurance extends Insurance {
    public CarInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public void calculate() {
        // Implement calculation logic for Car Insurance
    }
}
