public class Book {
    protected int year;
    protected String name;
    protected Genre genre;

    public enum Genre {
        NOVEL,
        POEM,
        FAIRY_TAIL,
        FICTION
    }

    public Book(String name, int year, Genre genre) {
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void Print(){
        System.out.printf("Name: %s, Genre: %s, Year: %d", name,genre,year);
        System.out.println();
    }
}
