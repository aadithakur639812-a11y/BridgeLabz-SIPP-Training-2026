import java.util.Scanner;

public class NaturalNumberSumFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number > 0) {
            int formulaSum = number * (number + 1) / 2;
            int loopSum = 0;
            for (int i = 1; i <= number; i++) {
                loopSum += i;
            }
            System.out.println("Formula sum: " + formulaSum);
            System.out.println("For loop sum: " + loopSum);
            System.out.println("Both results are correct: " + (formulaSum == loopSum));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        scanner.close();
    }
}
