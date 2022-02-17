package com.gamingstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_details")
@NoArgsConstructor
@Getter
@Setter
public class ProductDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_details_id", nullable = false)
  private Integer productDetailsID;

  @Column(name = "product_details_name", nullable = false)
  private String productDetailsName;

  @Column(name = "product_details_value", nullable = false)
  private String productDetailsValue;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product products;

  public ProductDetails(String productDetailsName, String productDetailsValue, Product products) {
    this.productDetailsName = productDetailsName;
    this.productDetailsValue = productDetailsValue;
    this.products = products;
  }

  public ProductDetails(Integer productDetailsID, String productDetailsName,
      String productDetailsValue, Product product) {
    this.productDetailsID = productDetailsID;
    this.productDetailsName = productDetailsName;
    this.productDetailsValue = productDetailsValue;
    this.products = product;
  }

  @Override
  public String toString() {
    return productDetailsName + "=" + productDetailsValue;
  }
}
