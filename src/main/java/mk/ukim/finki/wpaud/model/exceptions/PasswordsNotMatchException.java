package mk.ukim.finki.wpaud.model.exceptions;

public class PasswordsNotMatchException extends RuntimeException {
    public PasswordsNotMatchException(){
        super("Passwords does not match");
    }
}
