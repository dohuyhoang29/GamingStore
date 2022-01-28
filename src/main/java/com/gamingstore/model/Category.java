package com.gamingstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Column(name = "categoryID", length = 11, nullable = false)
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

  public Category(String categoryName, String description, String status) {
    this.categoryName = categoryName;
    this.description = description;
    this.status = status;
  }
}
