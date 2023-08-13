import java.util.ArrayList;
import java.util.List;

abstract class Account implements Comparable<Account> {
    enum AuthenticationStatus { SUCCESS, FAIL }

    private AuthenticationStatus loginStatus;
    private User user;
    private ArrayList<Insurance> insurances;

    public Account(User user) {
        this.user = user;
        this.loginStatus = AuthenticationStatus.FAIL;
        this.insurances = new ArrayList<>();
    }

    public AuthenticationStatus getLoginStatus() {
        return loginStatus;
    }

    public User getUser() {
        return user;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            this.loginStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Invalid email or password.");
        }
    }

    public void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }
    public void showUserInfo() {
        System.out.println("User Information:");
        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Age: " + user.getAge());
        System.out.println("Occupation: " + user.getOccupation());
        System.out.println("Last Login Date: " + user.getLastLoginDate());

        System.out.println("Addresses:");
        for (Address address : user.getAddresses()) {
            System.out.println(address.getAddressType() + ": " + address.getAddressDetails());
        }
    }
    @Override
    public int compareTo(Account other) {
        // Implement the comparison logic here based on your requirements
        // For example, you can compare the accounts based on their email addresses.
        return this.user.getEmail().compareTo(other.user.getEmail());
    }

}
