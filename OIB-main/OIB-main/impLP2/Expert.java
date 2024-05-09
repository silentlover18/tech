import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    String name;
    String department;
    double performanceRating;
    double attendanceRating;
    double productivityRating;
    double trainingRating;
    double jobCompetenciesRating;
    double adaptabilityRating;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
        this.performanceRating = 0;
        this.attendanceRating = 0;
        this.productivityRating = 0;
        this.trainingRating = 0;
        this.jobCompetenciesRating = 0;
        this.adaptabilityRating = 0;
    }

    public void evaluatePerformance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter attendance rating (1-10): ");
        this.attendanceRating = scanner.nextDouble();
        System.out.print("Enter productivity rating (1-10): ");
        this.productivityRating = scanner.nextDouble();
        System.out.print("Enter training rating (1-10): ");
        this.trainingRating = scanner.nextDouble();
        System.out.print("Enter job competencies rating (1-10): ");
        this.jobCompetenciesRating = scanner.nextDouble();
        System.out.print("Enter adaptability rating (1-10): ");
        this.adaptabilityRating = scanner.nextDouble();

        // Calculate the overall performance rating based on different criteria
        this.performanceRating = (this.attendanceRating + this.productivityRating + this.trainingRating
                + this.jobCompetenciesRating + this.adaptabilityRating) / 5;
    }

    public void displayPerformance() {
        System.out.println("Employee: " + this.name);
        System.out.println("Department: " + this.department);
        System.out.println("Performance Rating: " + this.performanceRating);
    }
}

class EmployeeExpertSystem {
    List<Employee> employees;

    public EmployeeExpertSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String department) {
        Employee employee = new Employee(name, department);
        this.employees.add(employee);
    }

    public void removeEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.name.equals(name)) {
                this.employees.remove(employee);
                System.out.println("\nEmployee " + name + " removed successfully.");
                return;
            }
        }
        System.out.println("Employee " + name + " not found.");
    }

    public void updateEmployeePerformance(String name) {
        for (Employee employee : this.employees) {
            if (employee.name.equals(name)) {
                employee.evaluatePerformance();
                System.out.println("\nPerformance for " + name + " updated successfully.");
                return;
            }
        }
        System.out.println("Employee " + name + " not found.");
    }

    public void calculateAveragePerformance() {
        if (this.employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        double totalRating = 0;
        for (Employee employee : this.employees) {
            totalRating += employee.performanceRating;
        }

        double averageRating = totalRating / this.employees.size();
        System.out.println("Average Performance Rating is : " + averageRating);
    }

    public void displayAllEmployees() {
        if (this.employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : this.employees) {
            employee.displayPerformance();
        }
    }
}

public class Expert{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeExpertSystem expertSystem = new EmployeeExpertSystem();

        while (true) {
            System.out.println("\nEmployee Performance Evaluation Expert System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Performance");
            System.out.println("4. Calculate Average Performance");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("\nEnter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee department: ");
                    String department = scanner.nextLine();
                    expertSystem.addEmployee(name, department);
                    System.out.println("Employee " + name + " added successfully.");
                    break;

                case "2":
                    System.out.print("\nEnter employee name: ");
                    name = scanner.nextLine();
                    expertSystem.removeEmployee(name);
                    break;

                case "3":
                    System.out.print("\nEnter employee name: ");
                    name = scanner.nextLine();
                    expertSystem.updateEmployeePerformance(name);
                    break;

                case "4":
                    expertSystem.calculateAveragePerformance();
                    break;

                case "5":
                    expertSystem.displayAllEmployees();
                    break;

                case "6":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

