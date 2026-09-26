public class Q5 {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Q5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        Q5 e1 = new Q5("Rahul", 50000);
        Q5 e2 = new Q5("Priya", 60000);
        Q5 e3 = new Q5("Arjun", 55000);

        Q5.printCompanyInfo();
    }
}