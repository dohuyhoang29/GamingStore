package com.gamingstore.controller.admin;

import com.gamingstore.model.Account;
import com.gamingstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductManagementController {

  @Autowired
  private AccountService service;

  @GetMapping("/admin/product/show_product")
  public String showAccountManagement(Model model) {
    Iterable<Account> listAccounts = service.findAllAccount();
    model.addAttribute("listAccounts", listAccounts);

    return "/admin/product_management";
  }
}
