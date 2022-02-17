package com.gamingstore.controller.admin;

import com.gamingstore.model.Account;
import com.gamingstore.service.AccountService;
import com.gamingstore.service.RoleService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AccountManagementController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private RoleService roleService;

  @GetMapping("/admin/account/show_account")
  public String showAccountManagement(Model model) {
    Iterable<Account> listAccounts = accountService.findAllAccount();
    model.addAttribute("listAccounts", listAccounts);

    return "/admin/account/account_management";
  }

  @GetMapping("/admin/account/insert")
  public String insertAccount(Model model) {
    model.addAttribute("account", new Account());
    model.addAttribute("listRoles", roleService.getAllRole());

    return "/admin/account/form_account";
  }

  @PostMapping("/admin/account/save")
  public String saveAccount(@Valid Account account, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("listRoles", roleService.getAllRole());

      return "/admin/account/form_account";
    }

    accountService.saveAccount(account);

    return "redirect:/admin/account/show_account";
  }

  @GetMapping("/admin/account/edit/{id}")
  public String editAccount(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("account", accountService.findAccountById(id));
    model.addAttribute("listRoles", roleService.getAllRole());

    return "/admin/account/form_account";
  }

  @GetMapping("/admin/account/delete/{id}")
  public String deleteAccount(@PathVariable("id") Integer id) {
    accountService.deleteAccountById(id);

    return "redirect:/admin/account/show_account";
  }

  @GetMapping("/admin/account_management/lock/{id}")
  public String lockAccount(@PathVariable("id") Integer id) {
    accountService.lockAccount(id);

    return "redirect:/admin/account/account_management";
  }

  @GetMapping("/admin/account_management/unlock/{id}")
  public String unLockAccount(@PathVariable("id") Integer id) {
    accountService.unLockAccount(id);

    return "redirect:/admin/account_management";
  }
}
