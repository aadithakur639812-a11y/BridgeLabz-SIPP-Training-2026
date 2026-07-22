import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductInventoryChecker {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length != 2) {
                    continue;
                }

                String productName = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());

                if (quantity == 0) {
                    System.out.println(productName + " is out of stock");
                }
            }
        } catch (IOException exception) {
            System.out.println("Error reading inventory file");
        }
    }
}
