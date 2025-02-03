import java.util.LinkedList;
import java.util.Queue;

public class BookShelf {
    private Queue<String> books;

    public BookShelf() {
        books = new LinkedList<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    public String takeBook() {
        return books.poll();
    }
    public String printAllBooks() {
        if (books.isEmpty()) {
            return "No books on the shelf.";
        } else {
            return ("Books on the shelf: " + books);
        }
    }
}
