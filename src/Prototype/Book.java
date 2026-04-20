package Prototype;

public class Book implements Cloneable {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public Book(String author, String title) {
        this(author, title, "", 0);
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone(); // safe (only primitives + String)
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }

    public String getTitle() {
        return title;
    }
}