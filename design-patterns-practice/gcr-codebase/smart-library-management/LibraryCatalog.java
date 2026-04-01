import java.util.*;

public class LibraryCatalog{
    private static LibraryCatalog catalog;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private LibraryCatalog(){ }

    public static synchronized LibraryCatalog getInstance(){
        if(catalog == null) catalog = new LibraryCatalog();
        return catalog;
    }

    public void addObserver(Observer o){ observers.add(o); }
    public void removeObserver(Observer o){ observers.remove(o); }

    public void addBook(Book book){
        books.add(book);
        notifyObservers(book.getTitle());
    }

    public void notifyObservers(String bookname){
        for(Observer o : observers){
            o.update("New book available: " + bookname);
        }
    }
}