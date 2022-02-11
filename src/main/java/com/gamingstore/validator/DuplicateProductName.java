package com.gamingstore.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DuplicateProductNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.FIELD} )
public @interface DuplicateProductName {
  String message() default "Product Name is must be unique";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
