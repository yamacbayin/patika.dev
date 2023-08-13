class HomeAddress implements Address {
    private String address;

    public HomeAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddressType() {
        return "Home Address";
    }

    @Override
    public String getAddressDetails() {
        return address;
    }
}
