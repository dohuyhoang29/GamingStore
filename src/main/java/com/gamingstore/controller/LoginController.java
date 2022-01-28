package com.gamingstore.controller;

import com.gamingstore.model.Account;
import com.gamingstore.repositories.AccountRepositories;
import com.gamingstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepositories repo;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login/save")
    public String login (@ModelAttribute("account")Account account, Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("message", "Email or Password is correct");
//            return "login";
//        } else {
        return service.findAccountByEmailOrUsername(account);
//        }

//        return "/admin/dashboard";
    }
}
