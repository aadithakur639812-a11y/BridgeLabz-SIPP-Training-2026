import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (FileWriter writer = new FileWriter("expenses.txt", true)) {
            System.out.print("Enter expense category: ");
            String category = scanner.nextLine();

            System.out.print("Enter expense amount: ");
            double amount = scanner.nextDouble();

            writer.write(category + " - " + amount + "\n");
            System.out.println("Expense added successfully");
        } catch (IOException exception) {
            System.out.println("Error writing expense");
        } finally {
            scanner.close();
        }
    }
}
