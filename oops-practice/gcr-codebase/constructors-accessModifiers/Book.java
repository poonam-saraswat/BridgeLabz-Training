import java.util.*;
class Book {
    public String ISBN;
    protected String title;
    private String author;

    // Parameterized constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to get author
    public String getAuthor() {
        return author;
    }

    // Public method to set author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}