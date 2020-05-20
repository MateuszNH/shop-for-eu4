package com.listy.shopforeu4.repository;

import com.listy.shopforeu4.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component // ostatnia adnotacja do tworzenia beanów Springa
public class InMemoryUserRepository implements UserRepository{
    private List<User> users = new ArrayList<>();
    @Override
    public void save(User user) {
        users.add(user);
        System.out.println(users);
    }
}
