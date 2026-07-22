import java.util.Scanner;

public class NumberOfOneBits {
    public static int hammingWeight(int number) {
        int count = 0;

        while (number != 0) {
            count += number & 1;
            number = number >>> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        System.out.println("Number of 1 bits: " + hammingWeight(number));
        scanner.close();
    }
}
