package com.listy.shopforeu4.service;

import com.listy.shopforeu4.dto.UserDTO;
import com.listy.shopforeu4.model.User;
import com.listy.shopforeu4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service //spring bean declaration
public class RegisterService {
private UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(UserDTO userDTO){
        validateFieldsNotEmpty(userDTO);
        validatePasswdLength(userDTO);
        validateMailRequirements(userDTO);
        User user = new User(userDTO.getMail(),userDTO.getPasswd());
        userRepository.save(user);
    }
    public void validateFieldsNotEmpty(UserDTO userDTO){
        if(userDTO.getMail().isEmpty() || userDTO.getPasswd().isEmpty())  {
            throw new RegisterServiceException("pola nie mogą być puste"); // czy hasło ma 6 znaków, czy mail ma poprawną składnie ??? regex
        }

    }

    private void validateMailRequirements(UserDTO userDTO) {
        String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userDTO.getMail());
        if(!matcher.matches()){
            throw new RegisterServiceException("niepoprawny mail");
        }
    }

    private void validatePasswdLength(UserDTO userDTO) {
        if(userDTO.getPasswd().length()<6){
        throw new RegisterServiceException("zbyt krótkie hasło");
        }
    }
}
