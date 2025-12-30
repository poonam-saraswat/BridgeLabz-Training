public class BookDetails {
    // Attributes
    private String title;
    private String author;
    private double price;

    // Constructor
    public BookDetails(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    // Main method to test the Book class
    public static void main(String[] args) {
        // Creating Book objects
        BookDetails book1 = new BookDetails("2States", "Chetan Bhagat", 500.0);
        BookDetails book2 = new BookDetails("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);

        // Displaying book details
        book1.displayDetails();
        System.out.println(); // For better readability
        book2.displayDetails();
    }
}