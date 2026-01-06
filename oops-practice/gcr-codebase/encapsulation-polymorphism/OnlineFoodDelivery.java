// Interface for Discountable items
interface Discountable {
    double applyDiscount(double discountPercent);
    String getDiscountDetails();
}

// Abstract class FoodItem
abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
        System.out.println("-----------------------------------");
    }
}

// VegItem subclass
class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // No extra charges
    }

    @Override
    public double applyDiscount(double discountPercent) {
        double discount = (calculateTotalPrice() * discountPercent) / 100;
        return calculateTotalPrice() - discount;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg items eligible for standard discount.";
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem {
    private double nonVegCharge = 50; // extra charge per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + nonVegCharge) * getQuantity();
    }

    @Override
    public double applyDiscount(double discountPercent) {
        double discount = (calculateTotalPrice() * discountPercent) / 100;
        return calculateTotalPrice() - discount;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg items include extra charge of Rs. " + nonVegCharge + " per item.";
    }
}

// Main class
public class OnlineFoodDelivery {
    // Polymorphism: process different food items
    public static void processOrder(FoodItem[] items, double discountPercent) {
        for (FoodItem item : items) {
            item.getItemDetails();
            System.out.println(item.getDiscountDetails());
            System.out.println("Final Price after " + discountPercent + "% discount: " + item.applyDiscount(discountPercent));
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {
        FoodItem f1 = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem f2 = new NonVegItem("Chicken Biryani", 300, 3);
        FoodItem f3 = new VegItem("Veg Burger", 100, 4);

        FoodItem[] order = {f1, f2, f3};

        // Process order with polymorphism
        processOrder(order, 10); // applying 10% discount
    }
}
