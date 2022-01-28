package com.gamingstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
  private Integer categoryID;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "price", length = 50, nullable = false)
  private Float price;
}
