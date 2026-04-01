import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // HashMap to store product prices
        Map<String, Integer> productPrices = new HashMap<>();

        // LinkedHashMap to maintain order of items added to cart
        Map<String, Integer> cart = new LinkedHashMap<>();

        System.out.print("Enter number of products available in store: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input product prices
        for (int i = 0; i < n; i++) {
            System.out.print("Enter product name: ");
            String product = scanner.nextLine();

            System.out.print("Enter price of " + product + ": ");
            int price = scanner.nextInt();
            scanner.nextLine(); // consume newline

            productPrices.put(product, price);
        }

        System.out.print("\nEnter number of items to add to cart: ");
        int m = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Add items to cart
        for (int i = 0; i < m; i++) {
            System.out.print("Enter product name to add: ");
            String product = scanner.nextLine();

            if (productPrices.containsKey(product)) {
                cart.put(product, productPrices.get(product));
            } else {
                System.out.println("Product not found in store!");
            }
        }

        // Display cart in insertion order (LinkedHashMap)
        System.out.println("\nCart (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display items sorted by price (TreeMap with custom comparator)
        TreeMap<Integer, List<String>> sortedByPrice = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            Integer price = entry.getValue();

            sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        System.out.println("\nCart (Sorted by Price):");
        for (Map.Entry<Integer, List<String>> entry : sortedByPrice.entrySet()) {
            System.out.println("Price " + entry.getKey() + " -> " + entry.getValue());
        }

        scanner.close();
    }
}