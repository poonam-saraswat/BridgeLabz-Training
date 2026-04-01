import java.util.*;

// Book class
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

// BookShelf class
class BookShelf {
    private HashMap<String, LinkedList<Book>> catalog; // genre → list of books
    private HashSet<String> bookSet; // avoid duplicates

    public BookShelf() {
        catalog = new HashMap<>();
        bookSet = new HashSet<>();
    }

    // Add book to catalog
    public void addBook(String genre, String title, String author) {
        String key = title.toLowerCase() + "-" + author.toLowerCase();
        if (bookSet.contains(key)) {
            System.out.println("Duplicate book! Cannot add.");
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(new Book(title, author));
        bookSet.add(key);
        System.out.println("Book added: " + title + " under genre " + genre);
    }

    // Borrow book (remove from list)
    public void borrowBook(String genre, String title) {
        if (!catalog.containsKey(genre)) {
            System.out.println("Genre not found!");
            return;
        }

        LinkedList<Book> books = catalog.get(genre);
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.title.equalsIgnoreCase(title)) {
                it.remove();
                bookSet.remove(b.title.toLowerCase() + "-" + b.author.toLowerCase());
                System.out.println("Borrowed: " + b);
                return;
            }
        }
        System.out.println("Book not found in genre " + genre);
    }

    // Return book (insert back)
    public void returnBook(String genre, String title, String author) {
        addBook(genre, title, author);
    }

    // Print catalog
    public void printCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Library catalog is empty.");
            return;
        }
        System.out.println("\n--- Library Catalog ---");
        for (Map.Entry<String, LinkedList<Book>> entry : catalog.entrySet()) {
            System.out.println("Genre: " + entry.getKey());
            for (Book b : entry.getValue()) {
                System.out.println("   " + b);
            }
        }
    }
}

// Demo class with user input
public class BookShelfDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookShelf shelf = new BookShelf();

        int choice;
        do {
            System.out.println("\n--- BookShelf Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Print Catalog");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    shelf.addBook(genre, title, author);
                    break;
                case 2:
                    System.out.print("Enter Genre: ");
                    String genreBorrow = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String titleBorrow = sc.nextLine();
                    shelf.borrowBook(genreBorrow, titleBorrow);
                    break;
                case 3:
                    System.out.print("Enter Genre: ");
                    String genreReturn = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String titleReturn = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String authorReturn = sc.nextLine();
                    shelf.returnBook(genreReturn, titleReturn, authorReturn);
                    break;
                case 4:
                    shelf.printCatalog();
                    break;
                case 5:
                    System.out.println("Exiting BookShelf...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}