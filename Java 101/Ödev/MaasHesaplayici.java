
public class MaasHesaplayici {

    public static void main(String[] args) {
        MaasHesaplayici main = new MaasHesaplayici();
        MaasHesaplayici.Employee employee = main.new Employee("John Doe", 2000, 45, 1985);
        System.out.println(employee);
    }

    public class Employee {
        String name;
        double salary;
        int workHours;
        int hireYear;

        public Employee(String name, double salary, int workHours, int hireYear) {
            this.name = name;
            this.salary = salary;
            this.workHours = workHours;
            this.hireYear = hireYear;
        }

        public double tax() {
            double taxRate;
            if (salary < 1000) {
                taxRate = 0;
            } else {
                taxRate = 0.03;
            }
            return taxRate * salary;
        }

        public double bonus() {
            double bonusSalary;
            if (workHours < 40) {
                bonusSalary = 0;
            } else {
                bonusSalary = (workHours - 40) * 30;
            }
            return bonusSalary;
        }

        public double raiseSalary() {
            double rate;
            int workYears = 2021 - hireYear;
            if (workYears < 10) {
                rate = 0.05;
            } else if (workYears < 20) {
                rate = 0.1;
            } else {
                rate = 0.15;
            }
            return rate * salary;
        }


        @Override
        public String toString() {
            double tax = tax();
            double bonus = bonus();
            double raise = raiseSalary();
            double total = (salary + bonus + raise) - tax;

            StringBuilder builder = new StringBuilder();
            builder
                    .append("Adı: ").append(name).append("\n")
                    .append("Maaşı: ").append(salary).append("\n")
                    .append("Çalışma Saati: ").append(workHours).append("\n")
                    .append("Başlangıç Yılı: ").append(hireYear).append("\n")
                    .append("Vergi: ").append(tax).append("\n")
                    .append("Bonus: ").append(bonus).append("\n")
                    .append("Maaş Artışı: ").append(raise).append("\n")
                    .append("Vergi ve Bonuslar ile birlikte maaş: ").append((salary + bonus - tax)).append("\n")
                    .append("Toplam Maaş: ").append(total).append("\n");

            return builder.toString();
        }
    }


}