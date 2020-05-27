package com.listy.shopforeu4.service;

import com.listy.shopforeu4.dto.FormDTO;
import com.listy.shopforeu4.model.Team;
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

    public void addTeam(FormDTO formDTO){
        validateFieldsNotEmpty(formDTO);
        validatePasswdLength(formDTO);
        //validateLoginRequirement(formDTO);
        User leader = new User(formDTO.getLeaderLogin(),formDTO.getLeaderPassword(),true);
        User player = new User(formDTO.getPlayerLogin(),formDTO.getPlayerPassword(),false);
        Team team = new Team(leader,player,formDTO.getTeamName());

        userRepository.save(leader);
        userRepository.save(player);
    }
    public void validateFieldsNotEmpty(FormDTO formDTO){
    /*    if(user.getLogin().isEmpty() || user.getPassword().isEmpty())  {
            throw new RegisterServiceException("pola nie mogą być puste"); // czy hasło ma 6 znaków, czy mail ma poprawną składnie ??? regex
        }
do domu*/
    }

    private void validateLoginRequirement(FormDTO formDTO) {
        String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formDTO.getLeaderLogin());
        if(!matcher.matches()){
            throw new RegisterServiceException("niepoprawny mail");
        } //i jeszcze drugiemu i zmiana regexu na loginowy
    }

    private void validatePasswdLength(FormDTO formDTO) {
        if(formDTO.getLeaderPassword().length()<6){
        throw new RegisterServiceException("zbyt krótkie hasło");
        } // też drugiego dodać
    }
}
