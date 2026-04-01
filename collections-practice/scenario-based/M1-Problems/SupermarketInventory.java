package M1-Problems;

import java.util.*;

// Base Product class
abstract class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract void displayDetails();

    double getTotalValue() {
        return price * quantity;
    }
}

// Electronics subclass
class Electronics extends Product {
    int warranty; // in months

    Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    @Override
    void displayDetails() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity +
                           ", Warranty: " + warranty + " months");
    }
}

// Clothing subclass
class Clothing extends Product {
    String size;

    Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    @Override
    void displayDetails() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity +
                           ", Size: " + size);
    }
}

public class SupermarketInventory {
    private static List<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < num; i++) {
            String line = sc.nextLine().trim();
            addProduct(line);
        }

        displayInventory();
        calculateTotalValue();
        sc.close();
    }

    private static void addProduct(String line) {
        String[] parts = line.split("\\s*,\\s*"); // split by comma with trimming
        String type = parts[0];

        if (type.equalsIgnoreCase("Electronics")) {
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            int quantity = Integer.parseInt(parts[3]);
            int warranty = Integer.parseInt(parts[4]);
            Product p = new Electronics(name, price, quantity, warranty);
            inventory.add(p);
            System.out.println("Product added to inventory: " + name);
        } else if (type.equalsIgnoreCase("Clothing")) {
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            int quantity = Integer.parseInt(parts[3]);
            String size = parts[4];
            Product p = new Clothing(name, price, quantity, size);
            inventory.add(p);
            System.out.println("Product added to inventory: " + name);
        }
    }

    private static void displayInventory() {
        System.out.println("Inventory:");
        for (Product p : inventory) {
            p.displayDetails();
        }
    }

    private static void calculateTotalValue() {
        double total = 0;
        for (Product p : inventory) {
            total += p.getTotalValue();
        }
        System.out.printf("Total value of the inventory: %.2f%n", total);
    }
}