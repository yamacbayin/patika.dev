class BusinessAddress implements Address {
    private String address;

    public BusinessAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddressType() {
        return "Business Address";
    }

    @Override
    public String getAddressDetails() {
        return address;
    }
}

