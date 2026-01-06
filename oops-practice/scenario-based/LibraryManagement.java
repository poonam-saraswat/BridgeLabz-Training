import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("The book \"" + title + "\" is not available for checkout.");
        }
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }
}
public class LibraryManagement {
    private List<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public List<Book> searchBooksByTitle(String partialTitle) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(partialTitle.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Status: " + (book.isAvailable() ? "Available" : "Checked Out"));
        }
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                try {
                    book.checkOut();
                    System.out.println("You have successfully checked out \"" + title + "\".");
                } catch (BookNotAvailableException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Book titled \"" + title + "\" not found in the library.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                System.out.println("You have successfully returned \"" + title + "\".");
                return;
            }
        }
        System.out.println("Book titled \"" + title + "\" not found in the library.");
    }
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("1984", "George Orwell");
        library.addBook("The Catcher in the Rye", "J.D. Salinger");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Library Books:");
        library.displayBooks();

        System.out.println("\nSearch for books by title (enter partial title): ");
        String searchQuery = scanner.nextLine();
        List<Book> foundBooks = library.searchBooksByTitle(searchQuery);
        if (foundBooks.isEmpty()) {
            System.out.println("No books found with the title containing \"" + searchQuery + "\".");
        } else {
            System.out.println("Found Books:");
            for (Book book : foundBooks) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Status: " + (book.isAvailable() ? "Available" : "Checked Out"));
            }
        }

        System.out.println("\nEnter the title of the book you want to check out: ");
        String checkoutTitle = scanner.nextLine();
        library.checkOutBook(checkoutTitle);

        System.out.println("\nUpdated Library Books:");
        library.displayBooks();

        System.out.println("\nEnter the title of the book you want to return: ");
        String returnTitle = scanner.nextLine();
        library.returnBook(returnTitle);

        System.out.println("\nFinal Library Books:");
        library.displayBooks();

        scanner.close();
    }
}
