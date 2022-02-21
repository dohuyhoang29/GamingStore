package com.gamingstore.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {

  public static final String CUSTOMER = "Customer";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id", length = 11, nullable = false)
  private Integer accountID;

  @Column(name = "email", nullable = false, unique = true)
  @NotEmpty(message = "Email is required")
  @Email(message = "Email must be correct format")
  private String email;

  @Column(name = "password", nullable = false)
  @NotEmpty(message = "Password is required")
  private String password;

  @NotEmpty(message = "First Name is required")
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotEmpty(message = "Last Name is required")
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "status")
  private String status;

  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinTable(name = "account_role",
      joinColumns = @JoinColumn(name = "account_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public Account(Integer id) {
    this.accountID = id;
  }

  public Account(String email, String password, String status) {
    this.email = email;
    this.password = password;
    this.status = status;
  }

  public void addRole(Role role) {
    this.roles.add(role);
  }

  public void removeRole(Role role) {
    this.roles.remove(role);
  }

  @Override
  public String toString() {
    return "Account{" +
        "email='" + email + '\'' +
        '}';
  }
}
