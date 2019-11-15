package generics_and_collections.aboutGenerics.library.genres;

import generics_and_collections.aboutGenerics.library.Book;

public class Children_Book extends Book implements Disk{

    private String cd = this.getTitle() + " Mp3 disk";

    public Children_Book(String title, String author) {
        super("Children's book", title, author);
    }

    public String getCd() {
        return cd;
    }

//    @Override
//    public int duration() {
//        return 0;
//    }
}
