import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Movie{
    private String title;
    private double rating;
    private int releaseYear;

    public Movie(String title, double rating, int releaseYear){
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle(){ return title; }
    public double getRating() { return rating; }
    public int getReleaseYear(){ return releaseYear; }

    @Override
    public String toString(){
        return title + " (" + releaseYear + ") - " + rating;
    }
}

public class TrendingMovies{
    public static void main(String[] args){
        List<Movie> movies = List.of(
            new Movie("Movie A", 8.9, 2024),
            new Movie("Movie B", 9.2, 2023),
            new Movie("Movie C", 8.5, 2022),
            new Movie("Movie D", 9.0, 2024),
            new Movie("Movie E", 7.9, 2021),
            new Movie("Movie F", 9.1, 2023),
            new Movie("Movie G", 8.8, 2024)
        );

        List<Movie> top5 = movies.stream()
            .filter(movie -> movie.getRating() >= 8)
            .sorted(Comparator.comparing(Movie::getRating).reversed().thenComparing(Movie::getReleaseYear).reversed())
            .limit(5)
            .collect(Collectors.toList());

        top5.forEach(System.out::println);

    }
}