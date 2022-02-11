package com.gamingstore.service;

import com.gamingstore.model.Product;
import com.gamingstore.repositories.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repo;

  public void save(Product product) {
    repo.save(product);
  }

  public Iterable<Product> getAllProduct() {
    return repo.findAll();
  }

  public Product getProductById(Integer id) {
    Optional<Product> product = repo.findById(id);
    if (product.isPresent()) {
      return product.get();
    } else {
      return null;
    }
  }
}
