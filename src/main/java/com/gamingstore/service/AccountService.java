package com.gamingstore.service;

import com.gamingstore.model.Account;
import com.gamingstore.repositories.AccountRepositories;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  @Autowired
  private AccountRepositories repo;

  public void saveAccount(Account accout) {
    repo.save(accout);
  }

  public String findAccountByEmailOrUsername(Account account) {
    Optional<Account> check = repo.findAccountByEmailAndUsername(account.getEmail(),
        account.getPassword());
    if (check.isPresent()) {
      return "redirect:/admin/dashboard";
    } else {
      return "/login";
    }
  }

  public Iterable<Account> findAllAccount() {
    return repo.findAll();
  }

  public void lockAccount(Integer id) {
    repo.lockAccountById(id);
  }

  public void unLockAccount(Integer id) {
    repo.unLockAccountById(id);
  }
}
