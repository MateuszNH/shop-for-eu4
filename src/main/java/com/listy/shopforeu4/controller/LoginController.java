package com.listy.shopforeu4.controller;
import com.listy.shopforeu4.dto.UserDTO;
import com.listy.shopforeu4.service.LoginService;
import com.listy.shopforeu4.service.LoginServiceException;
import com.listy.shopforeu4.service.RegisterService;
import com.listy.shopforeu4.service.RegisterServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //spring tworzenie obiektu i przekazuje innym
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login-form";
    }
    @PostMapping("/login")
    public String login(String mail, String passwd, Model model){
        UserDTO user = new UserDTO(mail,passwd);
        try {
            loginService.login(user);
        }catch (LoginServiceException e){
            model.addAttribute("error",e.getMessage());
            return "login-failed";
        }
        return "login-success";
    }
}
