package jdbc.playingWithDatabases;

public class NoSuchPersonException extends RuntimeException {
    public NoSuchPersonException(){
        super("No such Person Exists");
    }
}
