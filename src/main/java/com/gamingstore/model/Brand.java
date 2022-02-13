package com.gamingstore.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class Brand {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "brand_id", nullable = false, unique = true)
  private Integer brandID;

  @Column(name = "brand_name", nullable = false, unique = true)
  private String brandName;

  @OneToMany
  @JoinColumn(name = "brand_id")
  private Set<Category> categories = new HashSet<>();

  public Brand() {
  }

  public Brand(Integer brandID, String brandName, Set<Category> categories) {
    this.brandID = brandID;
    this.brandName = brandName;
    this.categories = categories;
  }
}
