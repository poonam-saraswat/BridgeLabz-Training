import java.util.*;

class Product {
    String name;
    int price;
    double rating;
    int discount;

    Product(String name, int price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
}

public class SortingEcommerce {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 30000, 4.5, 10));
        products.add(new Product("Laptop", 60000, 4.8, 15));
        products.add(new Product("Tablet", 20000, 4.2, 20));

        products.sort((p1, p2) -> p1.price - p2.price);
        System.out.println(products);

        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println(products);

        products.sort((p1, p2) -> p2.discount - p1.discount);
        System.out.println(products);
    }
}
