import java.util.Scanner;

public class MultipleCatchArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = null;

        try {
            System.out.print("Enter array size (-1 to keep array uninitialized): ");
            int size = scanner.nextInt();

            if (size >= 0) {
                numbers = new int[size];
                System.out.println("Enter array elements:");
                for (int i = 0; i < size; i++) {
                    numbers[i] = scanner.nextInt();
                }
            }

            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid index!");
        } catch (NullPointerException exception) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}
