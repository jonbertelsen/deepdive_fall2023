package dat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Book
{
    private String title;
    private String author;
    private int publicationYear;
    private int rating;
    private int numberOfPages;

    public static List<Book> getBookCollection()
    {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 5, 1178));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 6, 310));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 4, 223));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 4, 251));
        books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 4, 317));
        books.add(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000, 7, 636));
        books.add(new Book("Kafka on the Shore", "Haruki Murakami", 2002, 10, 505));
        books.add(new Book("The Wind-Up Bird Chronicle", "Haruki Murakami", 1994, 4, 607));
        books.add(new Book("1Q84", "Haruki Murakami", 2009, 3, 925));
        return books;
    }
}
