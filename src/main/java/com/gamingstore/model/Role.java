package com.gamingstore.model;

import java.util.Objects;
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
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id", nullable = false)
  private Integer roleID;

  @Column(name = "role_name", nullable = false, unique = true)
  private String roleName;

  public Role(Integer id) {
    this.roleID = id;
  }

  public Role(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Role)) {
      return false;
    }

    Role role = (Role) o;

    return getRoleID() != null ? getRoleID().equals(role.getRoleID()) : role.getRoleID() == null;
  }

  @Override
  public int hashCode() {
    return getRoleID() != null ? getRoleID().hashCode() : 0;
  }

  @Override
  public String toString() {
    return roleName;
  }
}
