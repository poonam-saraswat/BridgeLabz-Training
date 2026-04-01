import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

class Book{
    private String title;
    private String genre;
    private int pages;

    public Book(String title, String genre, int pages){
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getTitle(){ return title; }
    public String getGenre(){ return genre; }
    public int getPages(){ return pages; } 
}

public class LibraryBook {
    public static void main(String[] args){
        List<Book> books = List.of(
            new Book("Book 1", "Thriller", 346),
            new Book("Book 2", "Thriller", 340),
            new Book("Book 3", "Romance", 356),
            new Book("Book 4", "Romance", 320),
            new Book("Book 5", "Horror", 400)
        );

       Map<String, IntSummaryStatistics> stats = books.stream()
            .collect(
                Collectors.groupingBy(
                    Book::getGenre,
                    Collectors.summarizingInt(Book::getPages))
            );
        
        stats.forEach((genre, stat) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total pages: " + stat.getSum());
            System.out.println("Average pages: " + stat.getAverage());
            System.out.println("Max pages: " + stat.getMax());
        });
    }    
}
