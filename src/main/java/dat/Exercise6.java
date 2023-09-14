package dat;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise6
{
    public static void main(String[] args) {
        // Create a list of books
        List<Book> books = Book.getBookCollection();

        // Calculate the average rating of all books
        double averageRating = books.stream()
            .mapToInt(Book::getRating)
            .average()
            .getAsDouble();
        System.out.println("Average rating: " + averageRating);

        // Filter and display books published after a specific year
        getBooksPublishedAfterYear(books, 2000)
            .forEach(System.out::println);

        // Sort books by rating in descending order
        books.stream()
            .sorted((b1, b2) -> b2.getRating() - b1.getRating())
            .forEach(System.out::println);

        // Find and display the title of the highest-rated book
        Book highestRatedBook = books.stream()
            .max(Comparator.comparing(Book::getRating))
                    .get();
        System.out.println("Highest rated book: " + highestRatedBook.getTitle());

        // Group books by author and calculate average rating for each author
        books.stream()
            .collect(Collectors.groupingBy(Book::getAuthor))
            .forEach((author, bookList) -> {
                double avgRating = bookList.stream()
                    .mapToInt(Book::getRating)
                    .average()
                    .getAsDouble();
                System.out.println(author + ": " + avgRating);
            });

        books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getRating)))
                .forEach((author, avgRating) -> System.out.println(author + ": " + avgRating));

        // Calculate the total number of pages for all books
        int totalPages = books.stream()
            .mapToInt(Book::getNumberOfPages)
            .sum();
        System.out.println("Total pages: " + totalPages);
    }

    //
    private static List<Book> getBooksPublishedAfterYear(List<Book> books, int year) {
        return books.stream()
            .filter(b -> b.getPublicationYear() > year)
            .collect(Collectors.toList());
    }
}
