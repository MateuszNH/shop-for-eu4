package com.listy.shopforeu4.repository;

import com.listy.shopforeu4.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component // ostatnia adnotacja do tworzenia beanów Springa
public class InMemoryUserRepository implements UserRepository{
    private List<User> users = new ArrayList<>();
    @Override
    public User save(User user) {
        users.add(user);
        System.out.println(users);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }
}
