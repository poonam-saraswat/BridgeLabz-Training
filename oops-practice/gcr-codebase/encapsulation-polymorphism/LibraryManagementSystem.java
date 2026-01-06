// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem implements Reservable {
    private int itemId;
    private String title;
    private String author;
    private boolean isReserved;
    private String borrowerName; // sensitive personal data

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
        this.borrowerName = null;
    }

    // Encapsulation: Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Sensitive field: only getter, no public setter
    public String getBorrowerName() {
        return borrowerName;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Reserved: " + (isReserved ? "Yes, by " + borrowerName : "No"));
        System.out.println("-----------------------------------");
    }

    // Reservable interface methods
    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            this.isReserved = true;
            this.borrowerName = borrowerName;
            System.out.println(title + " has been reserved by " + borrowerName);
        } else {
            System.out.println(title + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Book subclass
class Book extends LibraryItem {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 21 days loan for books
    }
}

// Magazine subclass
class Magazine extends LibraryItem {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days loan for magazines
    }
}

// DVD subclass
class DVD extends LibraryItem {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan for DVDs
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem item1 = new Book(101, "Effective Java", "Joshua Bloch");
        LibraryItem item2 = new Magazine(102, "National Geographic", "Various Authors");
        LibraryItem item3 = new DVD(103, "Inception", "Christopher Nolan");

        // Polymorphism: process items using LibraryItem reference
        LibraryItem[] items = {item1, item2, item3};

        for (LibraryItem item : items) {
            item.getItemDetails();
        }

        // Reserve items
        item1.reserveItem("Alice");
        item2.reserveItem("Bob");
        item3.reserveItem("Charlie");

        // Display details after reservation
        for (LibraryItem item : items) {
            item.getItemDetails();
        }
    }
}
