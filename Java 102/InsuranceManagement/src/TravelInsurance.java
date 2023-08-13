import java.util.Date;

class TravelInsurance extends Insurance {
    public TravelInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public void calculate() {
        // Implement calculation logic for Travel Insurance
    }
}
