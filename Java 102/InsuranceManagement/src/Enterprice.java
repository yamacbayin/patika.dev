class Enterprise extends Account {
    private static final double ENTERPRISE_MARGIN = 1.2;

    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurance.calculate();
        getInsurances().add(insurance);
    }
}