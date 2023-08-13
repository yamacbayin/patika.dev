import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Home Address: ");
        String homeAddressStr = scanner.nextLine();
        Address homeAddress = new HomeAddress(homeAddressStr);

        System.out.print("Enter Business Address: ");
        String businessAddressStr = scanner.nextLine();
        Address businessAddress = new BusinessAddress(businessAddressStr);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Occupation: ");
        String occupation = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        User user = new User(firstName, lastName, email, password, occupation, age);

        user.addAddress(homeAddress);
        user.addAddress(businessAddress);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate;
        Date endDate;
        try {
            System.out.print("Enter Insurance Start Date (dd/MM/yyyy): ");
            String startDateStr = scanner.nextLine();
            startDate = sdf.parse(startDateStr);

            System.out.print("Enter Insurance End Date (dd/MM/yyyy): ");
            String endDateStr = scanner.nextLine();
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        System.out.print("Enter Health Insurance Price: ");
        double healthInsurancePrice = scanner.nextDouble();
        scanner.nextLine();
        Insurance healthInsurance = new HealthInsurance("Health Insurance", healthInsurancePrice, startDate, endDate);

        System.out.print("Enter Residence Insurance Price: ");
        double residenceInsurancePrice = scanner.nextDouble();
        scanner.nextLine();
        Insurance residenceInsurance = new ResidenceInsurance("Residence Insurance", residenceInsurancePrice, startDate, endDate);

        Individual individualAccount = new Individual(user);
        Enterprise enterpriseAccount = new Enterprise(user);

        individualAccount.addInsurance(healthInsurance);
        enterpriseAccount.addInsurance(residenceInsurance);

        AccountManager accountManager = new AccountManager();
        accountManager.addAccount(individualAccount);
        accountManager.addAccount(enterpriseAccount);

        System.out.print("Enter email: ");
        email = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        Account loggedInAccount = accountManager.login(email, password);
        if (loggedInAccount != null) {
            System.out.println("Login successful!");
            loggedInAccount.showUserInfo();
            System.out.println("Addresses:");
            for (Address address : loggedInAccount.getUser().getAddresses()) {
                System.out.println(address.getAddressDetails());
            }

            System.out.println("Insurances:");
            for (Insurance insurance : loggedInAccount.getInsurances()) {
                System.out.println("Name: " + insurance.getName() + ", Price: " + insurance.getPrice());
            }
        } else {
            System.out.println("Invalid email or password.");
        }
    }
}
