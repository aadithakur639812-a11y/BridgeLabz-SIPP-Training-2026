import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(int quantityToAdd) {
        if (quantityToAdd > 0) {
            quantity += quantityToAdd;
            System.out.println("Item added to cart");
        } else {
            System.out.println("Quantity must be positive");
        }
    }

    void removeItem(int quantityToRemove) {
        if (quantityToRemove <= 0) {
            System.out.println("Quantity must be positive");
        } else if (quantityToRemove <= quantity) {
            quantity -= quantityToRemove;
            System.out.println("Item removed from cart");
        } else {
            System.out.println("Cannot remove more than available quantity");
        }
    }

    double calculateTotalCost() {
        return price * quantity;
    }

    void displayTotalCost() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

public class ShoppingCartSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter initial quantity: ");
        int quantity = scanner.nextInt();

        CartItem cartItem = new CartItem(itemName, price, quantity);

        System.out.print("Enter quantity to add: ");
        int quantityToAdd = scanner.nextInt();
        cartItem.addItem(quantityToAdd);

        System.out.print("Enter quantity to remove: ");
        int quantityToRemove = scanner.nextInt();
        cartItem.removeItem(quantityToRemove);

        cartItem.displayTotalCost();
        scanner.close();
    }
}
