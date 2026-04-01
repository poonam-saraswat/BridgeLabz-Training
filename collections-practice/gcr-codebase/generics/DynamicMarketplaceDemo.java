import java.util.ArrayList;
import java.util.List;

// Base interface for categories
interface Category {
    String getCategoryName();
}

// Specific categories
class BookCategory implements Category {
    private String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }

    @Override
    public String getCategoryName() {
        return "Book Genre: " + genre;
    }
}

class ClothingCategory implements Category {
    private String type;

    public ClothingCategory(String type) {
        this.type = type;
    }

    @Override
    public String getCategoryName() {
        return "Clothing Type: " + type;
    }
}

class GadgetCategory implements Category {
    private String brand;

    public GadgetCategory(String brand) {
        this.brand = brand;
    }

    @Override
    public String getCategoryName() {
        return "Gadget Brand: " + brand;
    }
}

// Generic Product class with bounded type parameter
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return name + " | Price: " + price + " | " + category.getCategoryName();
    }
}

// Utility class with generic method
class MarketplaceUtils {
    // Generic method to apply discount
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied: " + percentage + "% on " + product.getName());
    }

    // Display catalog
    public static void displayCatalog(List<? extends Product<?>> catalog) {
        for (Product<?> product : catalog) {
            System.out.println(product.getDetails());
        }
    }
}

// Demo class
public class DynamicMarketplaceDemo {
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();

        // Add products
        Product<BookCategory> book = new Product<>("Java Programming", 500, new BookCategory("Technology"));
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 1200, new ClothingCategory("Men's Wear"));
        Product<GadgetCategory> phone = new Product<>("Smartphone", 25000, new GadgetCategory("Samsung"));

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        // Display catalog before discount
        System.out.println("=== Catalog Before Discount ===");
        MarketplaceUtils.displayCatalog(catalog);

        // Apply discounts
        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(shirt, 20);
        MarketplaceUtils.applyDiscount(phone, 5);

        // Display catalog after discount
        System.out.println("\n=== Catalog After Discount ===");
        MarketplaceUtils.displayCatalog(catalog);
    }
}