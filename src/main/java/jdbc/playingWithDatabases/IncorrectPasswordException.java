package jdbc.playingWithDatabases;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(){
        super("Incorrect password");
    }
}
