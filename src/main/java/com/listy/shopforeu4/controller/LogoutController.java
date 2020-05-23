package com.listy.shopforeu4.controller;

import com.listy.shopforeu4.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    private LoginService loginService;

    public LogoutController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/logout")
    public String logout(){
    loginService.logout();
    return "redirect:/";
}
}
