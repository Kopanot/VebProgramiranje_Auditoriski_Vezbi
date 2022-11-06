package mk.ukim.finki.wpaud.bootstrap;

import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.model.User;
import org.springframework.objenesis.strategy.SingleInstantiatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categoryList = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    @PostConstruct  //da se povika init() metodot
    public void init(){
        categoryList.add(new Category("Software", "Software Category"));
        categoryList.add(new Category("Books","Books Category"));

        users.add(new User("stefan.atanasovski", "sa", "Stefan", "Atanasovski") );
        users.add(new User("risto.ristevski", "rr", "Riste", "Ristevski") );
    }

}
