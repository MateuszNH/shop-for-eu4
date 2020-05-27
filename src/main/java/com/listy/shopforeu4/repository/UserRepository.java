package com.listy.shopforeu4.repository;

import com.listy.shopforeu4.model.User;

public interface UserRepository {
     User save(User user); // findbymail
     User findByLogin(String login);
}
