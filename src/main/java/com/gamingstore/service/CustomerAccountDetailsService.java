package com.gamingstore.service;

import com.gamingstore.model.Account;
import com.gamingstore.model.CustomerAccountDetails;
import com.gamingstore.repositories.AccountRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerAccountDetailsService implements UserDetailsService {

  @Autowired
  private AccountRepositories repo;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Account account = repo.findAccountByEmail(email);
    if (account == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return new CustomerAccountDetails(account);
  }
}
