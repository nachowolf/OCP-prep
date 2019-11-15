package generics_and_collections.aboutGenerics.library;

public abstract class Book {
    private String genre, title, author;

    public Book(String genre, String title, String author) {
        this.genre = genre;
        this.title = title;
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString(){
        return String.format("%s by %s", this.title, this.author);
    }
}
