public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook("Kniga1");
        bookShelf.addBook("Kniga2");
        System.out.println(bookShelf.printAllBooks());
        System.out.println(bookShelf.takeBook());
        System.out.println(bookShelf.takeBook());
        System.out.println(bookShelf.takeBook());
    }

}
