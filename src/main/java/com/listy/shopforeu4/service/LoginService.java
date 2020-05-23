package com.listy.shopforeu4.service;

import com.listy.shopforeu4.dto.UserDTO;
import com.listy.shopforeu4.model.User;
import com.listy.shopforeu4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    UserRepository repository;

    public LoginService(UserRepository repository) {
        this.repository = repository;
    }

    public void login(UserDTO formUser) {
     User user = repository.findByMail(formUser.getMail());
     if(user == null){
         throw new LoginServiceException("mail nie został odnaleziony");
     }
     if(!user.getPasswd().equals(formUser.getPasswd())){
        throw new LoginServiceException("hasło jest nieprawidłowe");
     }
    }

}
