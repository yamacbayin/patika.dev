import java.util.Date;

class HealthInsurance extends Insurance {
    public HealthInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public void calculate() {
        // Implement calculation logic for Health Insurance
    }
}