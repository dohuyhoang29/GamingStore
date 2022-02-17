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
@Table(name = "cart_item")
@Getter
@Setter
@NoArgsConstructor
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cart_item_id")
  private Integer cartItemID;

  private int quantity;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  public CartItem(Integer cartItemID, int quantity, Product product, Account account) {
    this.cartItemID = cartItemID;
    this.quantity = quantity;
    this.product = product;
    this.account = account;

  }public CartItem(int quantity, Product product, Account account) {
    this.quantity = quantity;
    this.product = product;
    this.account = account;
  }
}
