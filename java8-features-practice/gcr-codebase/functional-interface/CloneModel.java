class Product implements Cloneable {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneModel {

    public static void main(String[] args) {

        try {
            Product p1 = new Product("Laptop", 75000);
            Product p2 = (Product) p1.clone();

            System.out.println("Original: " + p1.name + " " + p1.price);
            System.out.println("Cloned  : " + p2.name + " " + p2.price);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
