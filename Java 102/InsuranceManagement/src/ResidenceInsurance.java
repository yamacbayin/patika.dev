import java.util.Date;

class ResidenceInsurance extends Insurance {
    public ResidenceInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public void calculate() {
        // Implement calculation logic for Residence Insurance
    }
}