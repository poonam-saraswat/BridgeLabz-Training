import java.util.*; 
class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // All books are available initially
    }

    public void displayDetails() {
        String status = isAvailable ? "Available" : "Checked Out";
        System.out.println("Title: " + title + ", Author: " + author + ", Status: " + status);
    }
}
class LibraryManagementSystem {
    private List<Book> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        // Sample books
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger"));
    }

    // Method to search books by partial title
    public List<Book> searchBooks(String partialTitle) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.title.toLowerCase().contains(partialTitle.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    // Method to checkout a book
    public boolean checkoutBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isAvailable) {
                book.isAvailable = false;
                return true; // Successfully checked out
            }
        }
        return false; // Book not found or not available
    }

    // Method to display all books
    public void displayAllBooks() {
        for (Book book : books) {
            book.displayDetails();
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System");
        System.out.println("All Books:");
        library.displayAllBooks();

        System.out.print("\nEnter a partial title to search: ");
        String partialTitle = scanner.nextLine();
        List<Book> searchResults = library.searchBooks(partialTitle);
        
        System.out.println("\nSearch Results:");
        for (Book book : searchResults) {
            book.displayDetails();
        }

        System.out.print("\nEnter the title of the book to checkout: ");
        String titleToCheckout = scanner.nextLine();
        if (library.checkoutBook(titleToCheckout)) {
            System.out.println("Successfully checked out: " + titleToCheckout);
        } else {
            System.out.println("Book not found or not available for checkout.");
        }

        System.out.println("\nUpdated Book List:");
        library.displayAllBooks();

        scanner.close();
    }
}
