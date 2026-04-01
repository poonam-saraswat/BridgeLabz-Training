import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {

    // Product class (Encapsulation)
    static class Product {
        private final String productId;
        private final String name;
        private int quantity;

        public Product(String productId, String name, int quantity) {
            this.productId = productId;
            this.name = name;
            this.quantity = quantity;
        }

        public String getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Product [ID=" + productId + ", Name=" + name + ", Quantity=" + quantity + "]";
        }
    }

    // Custom Exception
    static class OutOfStockException extends Exception {
        public OutOfStockException(String message) {
            super(message);
        }
    }

    // Interface for Alerts (Abstraction)
    interface AlertService {
        void sendLowStockAlert(Product product);
    }

    // Concrete Implementation of AlertService
    static class EmailAlertService implements AlertService {
        @Override
        public void sendLowStockAlert(Product product) {
            System.out.println("ALERT: Low stock for product " + product.getName() +
                    " (ID: " + product.getProductId() + "). Current quantity: " + product.getQuantity());
        }
    }

    // Inventory class (OOP)
    static class Inventory {
        private final Map<String, Product> products = new HashMap<>();
        private final AlertService alertService;
        private final int lowStockThreshold;

        public Inventory(AlertService alertService, int lowStockThreshold) {
            this.alertService = alertService;
            this.lowStockThreshold = lowStockThreshold;
        }

        // Add new product or increase quantity if it exists
        public void addOrUpdateProduct(String productId, String name, int quantity) {
            if (quantity < 0) {
                System.out.println("Invalid quantity. Must be >= 0");
                return;
            }

            Product product = products.get(productId);
            if (product == null) {
                product = new Product(productId, name, quantity);
                products.put(productId, product);
                System.out.println("Added new product: " + product);
            } else {
                product.setQuantity(product.getQuantity() + quantity);
                System.out.println("Updated product: " + product);
            }

            checkLowStock(product);
        }

        // Reduce stock for a product
        public void reduceStock(String productId, int quantity) throws OutOfStockException {
            if (quantity <= 0) {
                System.out.println("Invalid reduction quantity. Must be > 0");
                return;
            }

            Product product = products.get(productId);
            if (product == null) {
                System.out.println("Product not found: " + productId);
                return;
            }

            if (product.getQuantity() < quantity) {
                throw new OutOfStockException("Not enough stock for product: " + product.getName() +
                        " (requested " + quantity + ", available " + product.getQuantity() + ")");
            }

            product.setQuantity(product.getQuantity() - quantity);
            System.out.println("Stock reduced: " + product);
            checkLowStock(product);
        }

        // Set absolute stock (useful for corrections)
        public void setStock(String productId, int newQuantity) {
            if (newQuantity < 0) {
                System.out.println("Invalid quantity. Must be >= 0");
                return;
            }

            Product product = products.get(productId);
            if (product == null) {
                System.out.println("Product not found: " + productId);
                return;
            }

            product.setQuantity(newQuantity);
            System.out.println("Stock set: " + product);
            checkLowStock(product);
        }

        // Display all products
        public void displayInventory() {
            System.out.println("\nCurrent Inventory:");
            if (products.isEmpty()) {
                System.out.println("(empty)");
                return;
            }
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }

        // Internal: check and alert if low stock
        private void checkLowStock(Product product) {
            if (product.getQuantity() <= lowStockThreshold) {
                alertService.sendLowStockAlert(product);
            }
        }
    }

    // Demo main
    public static void main(String[] args) {
        AlertService alertService = new EmailAlertService();
        Inventory inventory = new Inventory(alertService, 5); // threshold = 5

        // Add products
        inventory.addOrUpdateProduct("P101", "Laptop", 10);
        inventory.addOrUpdateProduct("P102", "Mouse", 3);   // triggers low stock alert
        inventory.addOrUpdateProduct("P103", "Keyboard", 7);

        // Reduce stock
        try {
            inventory.reduceStock("P101", 6);               // Laptop -> 4 (alert)
            inventory.reduceStock("P102", 2);               // Mouse -> 1 (alert)
            inventory.reduceStock("P102", 5);               // throws OutOfStockException
        } catch (OutOfStockException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Set stock directly
        inventory.setStock("P103", 5);                      // Keyboard -> 5 (alert)

        // Display inventory
        inventory.displayInventory();
    }
}