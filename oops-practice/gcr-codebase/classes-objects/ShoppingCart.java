public class ShoppingCart {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public ShoppingCart(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add items to the cart
    public void addItem(int qty) {
        this.quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method to remove items from the cart
    public void removeItem(int qty) {
        if (qty <= this.quantity) {
            this.quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than present in the cart.");
        }
    }

    // Method to display total cost
    public void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.printf("Total cost: $%.2f%n", totalCost);
    }

    // Main method to test the ShoppingCart class
    public static void main(String[] args) {
        ShoppingCart cartItem = new ShoppingCart("Laptop", 999.99, 1);
        System.out.printf("Item: %s, Price: $%.2f, Quantity: %d%n", cartItem.itemName, cartItem.price, cartItem.quantity);

        cartItem.addItem(2);
        cartItem.removeItem(1);
        cartItem.displayTotalCost();
    }
}