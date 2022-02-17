package com.gamingstore.service;

import com.gamingstore.model.Role;
import com.gamingstore.repositories.RoleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  @Autowired
  private RoleRepositories repo;

  public Iterable<Role> getAllRole() {
    return repo.findAll();
  }
}
