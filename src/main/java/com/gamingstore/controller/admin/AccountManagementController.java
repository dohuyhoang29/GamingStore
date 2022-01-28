package com.gamingstore.controller.admin;

import com.gamingstore.model.Account;
import com.gamingstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AccountManagementController {

  @Autowired
  private AccountService service;

  @GetMapping("/admin/account/show_account")
  public String showAccountManagement(Model model) {
    Iterable<Account> listAccounts = service.findAllAccount();
    model.addAttribute("listAccounts", listAccounts);

    return "/admin/account/account_management";
  }

  @GetMapping("/admin/account_management/lock/{id}")
  public String lockAccount(@PathVariable("id") Integer id) {
    service.lockAccount(id);

    return "redirect:/admin/account/account_management";
  }

  @GetMapping("/admin/account_management/unlock/{id}")
  public String unLockAccount(@PathVariable("id") Integer id) {
    service.unLockAccount(id);

    return "redirect:/admin/account_management";
  }
}
