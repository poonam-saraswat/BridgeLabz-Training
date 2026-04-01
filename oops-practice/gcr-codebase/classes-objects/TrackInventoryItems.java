public class TrackInventoryItems {
    // Attributes
    private String itemCode;
    private String itemName;
    private double price;

    // Constructor
    public TrackInventoryItems(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayItemDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    // Method to calculate total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    // Main method to test the Item class
    public static void main(String[] args) {
        // Creating Item objects
        TrackInventoryItems item1 = new TrackInventoryItems("01AA", "Water bottle", 500.0);
        TrackInventoryItems item2 = new TrackInventoryItems("01BB", "Rice", 700.0);
        TrackInventoryItems item3 = new TrackInventoryItems("02AA", "blackboard", 400.0);

        // Displaying item details
        item1.displayItemDetails();
        item2.displayItemDetails();
        item3.displayItemDetails();

        // Example of calculating total cost
        int quantity = 3;
        System.out.println("Total cost for " + quantity + " " + item1.itemName + "(s): " + item1.calculateTotalCost(quantity));
    }
}