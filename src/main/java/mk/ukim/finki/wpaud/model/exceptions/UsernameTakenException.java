package mk.ukim.finki.wpaud.model.exceptions;

public class UsernameTakenException extends RuntimeException {
    public UsernameTakenException(){
        super("Username is taken");
    }
}
