import java.util.*;
class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    // Parameterized constructor
    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // By default, the book is available
    }

    // Method to borrow a book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book '" + title + "' is currently not available.");
        }
    }

    // Method to return a book
    public void returnBook() {
        isAvailable = true;
        System.out.println("You have successfully returned: " + title);
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}
class LibraryBookTest {
    public static void main(String[] args) {
        // Creating a LibraryBook object using parameterized constructor
        LibraryBook book1 = new LibraryBook("1984", "George Orwell", 9.99);
        System.out.println("Book Details:");
        book1.displayDetails();

        // Borrowing the book
        book1.borrowBook();
        book1.displayDetails();

        // Trying to borrow the book again
        book1.borrowBook();

        // Returning the book
        book1.returnBook();
        book1.displayDetails();
    }
}