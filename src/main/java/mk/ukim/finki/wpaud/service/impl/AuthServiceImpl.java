package mk.ukim.finki.wpaud.service.impl;

import mk.ukim.finki.wpaud.model.User;
import mk.ukim.finki.wpaud.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.wpaud.model.exceptions.InvalidUserCridentialsException;
import mk.ukim.finki.wpaud.model.exceptions.PasswordsNotMatchException;
import mk.ukim.finki.wpaud.model.exceptions.UsernameTakenException;
import mk.ukim.finki.wpaud.repository.InMemoryUserRepository;
import mk.ukim.finki.wpaud.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final InMemoryUserRepository userRepository;

    public AuthServiceImpl(InMemoryUserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCridentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatedPassword, String name, String surname) {
        if (username == null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
//        radi ova ne mozeshe da se napravi nova registracija
//        if (userRepository.findByUsername(username)!= null){
//            throw new UsernameTakenException();
//        }

        if (!password.equals(repeatedPassword)){
            throw new PasswordsNotMatchException();
        }
        User user = new User(username,password,name,surname);
        return userRepository.saveOrUpdate(user);
    }
}
