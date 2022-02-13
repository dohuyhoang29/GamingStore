package com.gamingstore.service;

import com.gamingstore.model.Brand;
import com.gamingstore.repositories.BrandRepositories;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
  @Autowired
  private BrandRepositories repo;

  public void saveBrand(Brand brand) {
    repo.save(brand);
  }

  public Iterable<Brand> getAllBrand() {
    return repo.findAll();
  }

  public Brand getBrandById(Integer id) {
    Optional<Brand> brand = repo.findById(id);

    return brand.orElse(null);
  }
}
