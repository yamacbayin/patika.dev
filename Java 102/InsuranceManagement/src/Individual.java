class Individual extends Account {
    private static final double INDIVIDUAL_MARGIN = 1.1;

    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurance.calculate();
        getInsurances().add(insurance);
    }
}