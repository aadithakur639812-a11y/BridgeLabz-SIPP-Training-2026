import java.util.Scanner;

public class TriangularParkRounds {
    public static int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(5000 / perimeter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first side of triangle in meters: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter second side of triangle in meters: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter third side of triangle in meters: ");
        double side3 = scanner.nextDouble();

        int rounds = calculateRounds(side1, side2, side3);
        System.out.println("The athlete must complete " + rounds + " rounds to finish a 5 km run");

        scanner.close();
    }
}
