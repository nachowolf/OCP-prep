package generics_and_collections.aboutGenerics.library;

import generics_and_collections.aboutGenerics.library.genres.Children_Book;
import generics_and_collections.aboutGenerics.library.genres.Disk;
import generics_and_collections.aboutGenerics.library.genres.Fiction;
import generics_and_collections.aboutGenerics.library.genres.Romance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MP3Player<T extends Disk>{
    private T disk;
    private Button button;

    public void insertDisk(T t){
        this.disk = t;
        this.button = Button.PLAY;

    }

public void push(Button button){
        this.button = button;
}
public String getStatus(){
        return this.disk.getCd() + " is " + this.button.getStatus();
}

    enum Button {
     PLAY("Playing"), PAUSE("Paused"), SKIPFORWARD("Skipped Forward"), SKIPBACKWARD("Skipped Backward");

     private String status;
     Button(String status){
         this.status = status;
     }

        public String getStatus() {
            return status;
        }

    }
}

public class Library {


    class Bookshelf<T extends Book>{

        private List<T> books = new ArrayList<>();

        public List<T> getFiction(){
            return books.stream().filter(book -> book instanceof Fiction).collect(Collectors.toList());
        }

        public List<T> getRomance(){
            return books.stream().filter(book -> book instanceof Romance).collect(Collectors.toList());
        }

        public List<T> getChildrenBook(){
            return books.stream().filter(book -> book instanceof Children_Book).collect(Collectors.toList());
        }

        public List<T> getAllBooks(){
            return books;
        }

        public void addBook(T book){
            books.add(book);
        }

    }

    public static void main(String[] args) {

        Library library = new Library();
        Library.Bookshelf<Book> bookshelf = library.new Bookshelf<>();

        Fiction hp3 = new Fiction("Harry Potter and the prisoner of Azkaban", "JK Rowling"),
                hp2 = new Fiction("Harry Potter and the chamber of secrets", "JK Rowling");

        Romance wb = new Romance("Warm Bodies", "Stefan");

        Children_Book mg = new Children_Book("Bedtime Stories from Mama Goose", "Sarah Conney");

        bookshelf.addBook(hp3);
        bookshelf.addBook(hp2);
        bookshelf.addBook(wb);
        bookshelf.addBook(mg);
//        bookshelf.addBook(n);

        System.out.println(bookshelf.getFiction());

        MP3Player<Disk> mp3Player = new MP3Player<>();

        mp3Player.insertDisk(mg);
        System.out.println(mp3Player.getStatus());

        mp3Player.push(MP3Player.Button.PAUSE);
        System.out.println(mp3Player.getStatus());

        final Disk tt = new Disk() {
            @Override
            public String getCd() {
                duration();
                return "This is anonymous";
            }

            //            @Override
            private int duration() {
                return 0;
            }
        };


        mp3Player.insertDisk(tt);

//  mp3Player.insertDisk(() -> "This is lambda");
//        System.out.println(mp3Player.getStatus());
//
    }
}
