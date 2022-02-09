package com.gamingstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "productID", length = 11, nullable = false)
  private Integer productID;

  @Column(name = "categoryID", length = 11, nullable = false)
  @NotNull(message = "Category Name is not empty")
  private Integer categoryID;

  @Column(name = "product_name", nullable = false, unique = true)
  @NotEmpty(message = "Product Name is not empty")
  private String productName;

  @Column(name = "price", length = 50, nullable = false)
  @NotNull(message = "Price is not empty")
  private Float price;
}
