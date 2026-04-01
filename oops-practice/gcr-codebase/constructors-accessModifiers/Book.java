import java.util.*;
class Book {
    // Static variable shared across all books
    static String libraryName = "Egmore Library";

    // Final variable for unique identifier
    final String isbn;
    String title;
    String author;

    // Constructor using 'this' to initialize instance variables
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}
class BookTest {
    public static void main(String[] args) {
        // Displaying library name using static method
        Book.displayLibraryName();

        // Creating Book objects using parameterized constructor
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book2 = new Book("1984", "George Orwell", "9780451524935");

        // Displaying book details
        System.out.println("\nBook 1 Details:");
        book1.displayDetails();

        System.out.println("\nBook 2 Details:");
        book2.displayDetails();
    }
}