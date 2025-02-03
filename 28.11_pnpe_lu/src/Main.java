import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        List<Book> newBookList;

        bookList.add(new Book("The Bear", 2021, Book.Genre.NOVEL));
        bookList.add(new Book("Insomnia", 2019, Book.Genre.FICTION));
        bookList.add(new Book("Pinko", 2024, Book.Genre.FAIRY_TAIL));
        bookList.add(new Book("Fanatic", 2023, Book.Genre.NOVEL));
        bookList.add(new Book("High Life", 1999, Book.Genre.POEM));
        bookList.add(new Book("Lapadundi", 2001, Book.Genre.FAIRY_TAIL));
        bookList.add(new Book("A Book", 2009, Book.Genre.NOVEL));
        bookList.add(new Book("The Tree", 2006, Book.Genre.POEM));


        System.out.println("Original books:");
        bookList.forEach(Book::Print);


        newBookList = bookList;
        newBookList.sort(Comparator.comparingInt(Book::getYear));
        System.out.println();
        System.out.println("Sorted books: ");
        newBookList.forEach(Book::Print);


        List<String> listOfTitles = bookList.stream().
                map(Book::getName).
                collect(Collectors.toList());
        System.out.println();
        System.out.println("Titles: ");
        System.out.println(listOfTitles);


        Map<Book.Genre, List<Book>> genreCollection = bookList.stream().
                collect(Collectors.groupingBy(Book::getGenre));
        System.out.println();
        System.out.print("Books grouped by genre:");

        genreCollection.forEach((genre, books) -> {
            System.out.println("\nGenre: " + genre);
            books.forEach(Book::Print);
        });
    }
}