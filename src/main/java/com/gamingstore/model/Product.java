package com.gamingstore.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

  @Column(name = "product_name", nullable = false)
  @NotEmpty(message = "Product Name is not empty")
  private String productName;

  @Column(name = "price", length = 50, nullable = false)
  @NotNull(message = "Price is not empty")
  private Float price;

  @Column(name = "status", nullable = true)
  private String status;

  @NotNull(message = "Category Name is not empty")
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
  private List<ProductDetails> productDetails = new ArrayList<>();

  public Product(Category category, String productName, Float price) {
    this.category = category;
    this.productName = productName;
    this.price = price;
  }

  public void addDetails(String name, String value) {
    this.productDetails.add(new ProductDetails(name, value, this));
  }

  public void setProductDetail(Integer id, String name, String value) {
    this.productDetails.add(new ProductDetails(id, name, value, this));
  }
}
