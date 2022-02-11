package com.gamingstore.validator;

import com.gamingstore.model.Product;
import com.gamingstore.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class DuplicateProductNameValidator implements ConstraintValidator<DuplicateProductName, String> {
  @Autowired
  private ProductService service;

  @Override
  public void initialize(DuplicateProductName constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    List<Product> productList = (List<Product>) service.getAllProduct();

    List<Product> listCheck = null;
    if (!productList.isEmpty()){
      listCheck = productList.stream().filter(p -> p.getProductName().equalsIgnoreCase(s)).collect(
          Collectors.toList());
    }

    return listCheck.isEmpty() || productList.isEmpty();
  }
}
