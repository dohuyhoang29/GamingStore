package com.gamingstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Validation implements ConstraintValidator<Validator, String> {
  @Override
  public void initialize(Validator validator){}

  @Override
  public boolean isValid(String s, ConstraintValidatorContext cxt) {
    return false;
  }

}
