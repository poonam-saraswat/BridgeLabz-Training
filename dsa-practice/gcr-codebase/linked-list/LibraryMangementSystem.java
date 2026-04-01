// Node class representing each Book
class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List Library Management System
class Library {
    private BookNode head = null;
    private BookNode tail = null;

    // Add book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int id, boolean available) {
        BookNode newNode = new BookNode(title, author, genre, id, available);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add book at the end
    public void addBookAtEnd(String title, String author, String genre, int id, boolean available) {
        BookNode newNode = new BookNode(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add book at a specific position (1-based index)
    public void addBookAtPosition(String title, String author, String genre, int id, boolean available, int position) {
        if (position == 1) {
            addBookAtBeginning(title, author, genre, id, available);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, id, available);
        BookNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addBookAtEnd(title, author, genre, id, available);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Remove book by Book ID
    public void removeBookById(int id) {
        if (head == null) return;

        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book with ID " + id + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    // Search by Book Title
    public void searchByTitle(String title) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Found Book: [ID=" + temp.bookId + ", Title=" + temp.title +
                        ", Author=" + temp.author + ", Genre=" + temp.genre +
                        ", Available=" + temp.isAvailable + "]");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with Title '" + title + "' not found.");
    }

    // Search by Author
    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Found Book: [ID=" + temp.bookId + ", Title=" + temp.title +
                        ", Author=" + temp.author + ", Genre=" + temp.genre +
                        ", Available=" + temp.isAvailable + "]");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No books found by Author '" + author + "'");
        }
    }

    // Update Availability Status
    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated for Book ID " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    // Display all books forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No books in library.");
            return;
        }
        BookNode temp = head;
        System.out.println("Books in Forward Order:");
        while (temp != null) {
            System.out.println("[ID=" + temp.bookId + ", Title=" + temp.title +
                    ", Author=" + temp.author + ", Genre=" + temp.genre +
                    ", Available=" + temp.isAvailable + "]");
            temp = temp.next;
        }
    }

    // Display all books reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books in library.");
            return;
        }
        BookNode temp = tail;
        System.out.println("Books in Reverse Order:");
        while (temp != null) {
            System.out.println("[ID=" + temp.bookId + ", Title=" + temp.title +
                    ", Author=" + temp.author + ", Genre=" + temp.genre +
                    ", Available=" + temp.isAvailable + "]");
            temp = temp.prev;
        }
    }

    // Count total number of books
    public void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }
}

// Driver class
public class LibraryMangementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd("The Alchemist", "Paulo Coelho", "Fiction", 101, true);
        library.addBookAtBeginning("Clean Code", "Robert C. Martin", "Programming", 102, true);
        library.addBookAtPosition("1984", "George Orwell", "Dystopian", 103, false, 2);
        library.addBookAtEnd("Effective Java", "Joshua Bloch", "Programming", 104, true);

        library.displayForward();
        library.displayReverse();

        System.out.println("\nSearch by Title (1984):");
        library.searchByTitle("1984");

        System.out.println("\nSearch by Author (Joshua Bloch):");
        library.searchByAuthor("Joshua Bloch");

        System.out.println("\nUpdate Availability of Book ID 103:");
        library.updateAvailability(103, true);

        System.out.println("\nRemove Book with ID 102:");
        library.removeBookById(102);

        library.displayForward();
        library.countBooks();
    }
}
