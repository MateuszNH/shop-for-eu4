package com.listy.shopforeu4.service;

import com.listy.shopforeu4.model.User;
import com.listy.shopforeu4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserRepository repository;
    private boolean logged;

    public LoginService(UserRepository repository) {
        this.repository = repository;
    }

    public void login(User formUser) {
     User user = repository.findByLogin(formUser.getLogin());
     if(user == null){
         throw new LoginServiceException("mail nie został odnaleziony");
     }
     if(!user.getPassword().equals(formUser.getPassword())){
        throw new LoginServiceException("hasło jest nieprawidłowe");
     }
     logged = true;
    }

    public boolean isLogged() {
        return logged;
    }
    public void logout(){
        logged = false;
    }
}
