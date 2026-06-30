import java.util.Scanner;

public class NumberCollector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        int index = 0;
        double total = 0.0;
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double value = scanner.nextDouble();
            if (value <= 0 || index == 10) {
                break;
            }
            numbers[index] = value;
            index++;
        }
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }
        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("Sum of all numbers: " + total);
        scanner.close();
    }
}
