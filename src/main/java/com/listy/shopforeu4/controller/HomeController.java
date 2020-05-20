package com.listy.shopforeu4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping   /*("/") to samo*/
    public String getHomepage(){
        return "index";
    }
}
