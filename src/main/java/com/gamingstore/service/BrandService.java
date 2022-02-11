package com.gamingstore.service;

import com.gamingstore.repositories.BrandRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
  @Autowired
  private BrandRepositories repo;

}
