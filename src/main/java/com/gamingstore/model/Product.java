package com.gamingstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id", length = 11, nullable = false)
  private Integer productID;

  @NotNull(message = "Category Name is not empty")
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @Column(name = "product_name", nullable = false)
  @NotEmpty(message = "Product Name is not empty")
  private String productName;

  @Column(name = "price", length = 50, nullable = false)
  @NotNull(message = "Price is not empty")
  private Float price;

  @Column(name = "status", nullable = true)
  private String status;

  public Product(Category category, String productName, Float price) {
    this.category = category;
    this.productName = productName;
    this.price = price;
  }
}
