import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();
        System.out.print("Enter third number: ");
        int number3 = scanner.nextInt();
        boolean firstIsLargest = number1 > number2 && number1 > number3;
        boolean secondIsLargest = number2 > number1 && number2 > number3;
        boolean thirdIsLargest = number3 > number1 && number3 > number2;
        System.out.println("Is the first number the largest? " + firstIsLargest);
        System.out.println("Is the second number the largest? " + secondIsLargest);
        System.out.println("Is the third number the largest? " + thirdIsLargest);
        scanner.close();
    }
}
