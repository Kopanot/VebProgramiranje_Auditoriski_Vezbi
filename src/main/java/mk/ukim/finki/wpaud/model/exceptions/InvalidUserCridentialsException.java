package mk.ukim.finki.wpaud.model.exceptions;

import mk.ukim.finki.wpaud.repository.InMemoryUserRepository;

public class InvalidUserCridentialsException extends RuntimeException{

    public InvalidUserCridentialsException(){
        super("Invalid user cridentials");
    }

}
