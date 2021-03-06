package com.listy.shopforeu4.controller;

import com.listy.shopforeu4.dto.FormDTO;
import com.listy.shopforeu4.service.RegisterService;
import com.listy.shopforeu4.service.RegisterServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private RegisterService registerService;
// dependency injection - wstrzyknięcie do konstruktora
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String register(Model model){
        FormDTO loginForm = new FormDTO();;
        model.addAttribute("loginForm",loginForm);
        return "register-form";
    }
    @PostMapping("/register")
    public String addNewTeam(FormDTO loginForm, Model model){
        try {
            registerService.addTeam(loginForm);
        }catch (RegisterServiceException e){
            model.addAttribute("error",e.getMessage());
            return "register-failed";
        }
        return "redirect:/login";
    }
}
