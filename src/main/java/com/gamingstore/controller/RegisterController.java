package com.gamingstore.controller;

import com.gamingstore.model.Account;
import com.gamingstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

  @Autowired
  private AccountService service;

  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("account", new Account());
    return "/register";
  }

  @PostMapping("/register")
  public String saveAccount(Account account) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      
    return "/register";
  }
}
