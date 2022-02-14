package com.gamingstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
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

  public Integer getProductDetailsID() {
    return productDetailsID;
  }

  public void setProductDetailsID(Integer productDetailsID) {
    this.productDetailsID = productDetailsID;
  }

  public String getProductDetailsName() {
    return productDetailsName;
  }

  public void setProductDetailsName(String productDetailsName) {
    this.productDetailsName = productDetailsName;
  }

  public String getProductDetailsValue() {
    return productDetailsValue;
  }

  public void setProductDetailsValue(String productDetailsValue) {
    this.productDetailsValue = productDetailsValue;
  }

  public Product getProducts() {
    return products;
  }

  public void setProducts(Product products) {
    this.products = products;
  }
}
