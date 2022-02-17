package com.gamingstore.service;

import com.gamingstore.repositories.CartItemRepositories;
import org.springframework.beans.factory.annotation.Autowired;

public class CartItemService {
  @Autowired
  private CartItemRepositories repo;
}
