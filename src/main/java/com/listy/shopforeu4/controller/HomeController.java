package com.listy.shopforeu4.controller;

import com.listy.shopforeu4.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private LoginService loginService;

    public HomeController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping   /*("/") to samo*/
    public String getHomepage(Model model){
        if(loginService.isLogged()){
            model.addAttribute("logged",true);
        }
        else model.addAttribute("logged",false);

        return "index";
    }
}
