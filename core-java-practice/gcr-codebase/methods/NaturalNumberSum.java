import java.util.Scanner;

public class NaturalNumberSum {
    public static int findSum(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        int sum = findSum(number);
        System.out.println("The sum of " + number + " natural numbers is " + sum);

        scanner.close();
    }
}
