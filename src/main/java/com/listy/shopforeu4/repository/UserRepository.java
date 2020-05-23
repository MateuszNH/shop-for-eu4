package com.listy.shopforeu4.repository;

import com.listy.shopforeu4.model.User;

public interface UserRepository {
     void save(User user); // findbymail
     User findByMail(String mail);
}
