import java.util.ArrayList;
import java.util.Date;

class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String occupation;
    private int age;
    private ArrayList<Address> addresses;
    private Date lastLoginDate;
    private ArrayList<Insurance> insurances;


    public User(String firstName, String lastName, String email, String password, String occupation, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.occupation = occupation;
        this.age = age;
        this.addresses = new ArrayList<>();
        this.lastLoginDate = new Date();
        this.insurances = new ArrayList<>();

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }
    public void addAddress(Address address) {
        addresses.add(address);
    }
    public void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }
}