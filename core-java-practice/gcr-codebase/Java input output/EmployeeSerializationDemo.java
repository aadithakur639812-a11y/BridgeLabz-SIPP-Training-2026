import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int employeeId;
    private String name;
    private String department;
    private double salary;

    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployeeInformation() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeSerializationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "employee.ser";

        try {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter department: ");
            String department = scanner.nextLine();

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();

            Employee employee = new Employee(employeeId, name, department, salary);

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                outputStream.writeObject(employee);
            }

            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                Employee recoveredEmployee = (Employee) inputStream.readObject();
                System.out.println("Recovered employee information:");
                recoveredEmployee.displayEmployeeInformation();
            }
        } catch (IOException exception) {
            System.out.println("File operation failed");
        } catch (ClassNotFoundException exception) {
            System.out.println("Employee class not found");
        } finally {
            scanner.close();
        }
    }
}
