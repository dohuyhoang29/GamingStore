package com.gamingstore.model;

import java.util.Set;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

  @Id
  @Column(name = "category_id", length = 11, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoryID;

  @Column(name = "category_name", nullable = false)
  @NotEmpty(message = "Category Name is not empty")
  private String categoryName;

  @Column(name = "description", nullable = false)
  @NotEmpty(message = "Description is not empty")
  private String description;

  @Column(name = "status", nullable = false)
  private String status;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Product> products;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;

  public Category(String categoryName, String description, String status) {
    this.categoryName = categoryName;
    this.description = description;
    this.status = status;
  }

  @Override
  public String toString() {
    return categoryName;
  }
}
