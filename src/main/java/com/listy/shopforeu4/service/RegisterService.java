package com.listy.shopforeu4.service;

import com.listy.shopforeu4.dto.UserDTO;
import com.listy.shopforeu4.model.User;
import com.listy.shopforeu4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service //spring bean declaration
public class RegisterService {
private UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(UserDTO userDTO){
        validateFieldsNotEmpty(userDTO);
        User user = new User(userDTO.getMail(),userDTO.getPasswd());
        userRepository.save(user);
    }
    public void validateFieldsNotEmpty(UserDTO userDTO){
        if(userDTO.getMail().isEmpty() || userDTO.getPasswd().isEmpty()){
            throw new RegisterServiceException("pola nie mogą być puste"); // czy hasło ma 6 znaków, czy mail ma poprawną składnie ??? regex
        }

    }
}
