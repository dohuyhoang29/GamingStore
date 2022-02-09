package com.gamingstore.service;

import com.gamingstore.model.Product;
import com.gamingstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repo;

  public void save(Product product) {
    repo.save(product);
  }
}
