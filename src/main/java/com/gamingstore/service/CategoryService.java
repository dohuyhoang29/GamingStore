package com.gamingstore.service;

import com.gamingstore.model.Category;
import com.gamingstore.repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepositories repo;

  public void saveCategory(Category category) {
    repo.save(category);
  }

  public Iterable<Category> findAllCategory() {
    return repo.findAll();
  }

  public Category findCategoryById(Integer id) {
    return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id : " + id)  );
  }
}
