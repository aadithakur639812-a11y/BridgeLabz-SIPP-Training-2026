import java.util.Scanner;

public class ConsecutiveSensorReadings {
    public static boolean isStrictlyIncreasing(int[] readings, int index) {
        if (index >= readings.length - 1) {
            return true;
        }
        if (readings[index] >= readings[index + 1]) {
            return false;
        }
        return isStrictlyIncreasing(readings, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of readings: ");
        int size = scanner.nextInt();
        int[] readings = new int[size];

        System.out.println("Enter temperature readings:");
        for (int i = 0; i < size; i++) {
            readings[i] = scanner.nextInt();
        }

        System.out.println(isStrictlyIncreasing(readings, 0));
        scanner.close();
    }
}
