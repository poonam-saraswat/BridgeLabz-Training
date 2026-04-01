package inheritance;

import java.util.*;
class Book {
    String title;
    int publicationYear;

    // Parameterized constructor
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book information
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    // Parameterized constructor
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Method to display author information
    public void displayAuthorInfo() {
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        // Creating an Author object which also represents a Book
        Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "American novelist and short story writer.");

        // Displaying book information
        author.displayInfo();
        // Displaying author information
        author.displayAuthorInfo();
    }
}
