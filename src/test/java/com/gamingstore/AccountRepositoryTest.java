package com.gamingstore;

import com.gamingstore.model.Account;
import com.gamingstore.model.Role;
import com.gamingstore.repositories.AccountRepositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class AccountRepositoryTest {
  @Autowired
  private AccountRepositories repo;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void testCreateRoles() {
    Role roleAdmin = new Role("Administrator");
    Role roleEditor = new Role("Editor");
    Role roleVisitor = new Role("Visitor");

    entityManager.persist(roleAdmin);
    entityManager.persist(roleEditor);
    entityManager.persist(roleVisitor);
  }

  @Test
  public void testCreateNewUserWithOneRole() {
    Role roleAdmin = entityManager.find(Role.class, 1);

    Account account = new Account("hoang@gmail.com", "1234", "");
    account.addRole(roleAdmin);

    repo.save(account);
  }

  @Test
  public void testCreateNewUserWithTwoRole() {
    Role roleEditor = entityManager.find(Role.class, 2);
    Role roleVisitor = entityManager.find(Role.class, 3);

    Account account = new Account("editor@gmail.com", "1234", "");
    account.addRole(roleEditor);
    account.addRole(roleVisitor);

    repo.save(account);
  }

  @Test
  public void testAssignRoleToExistingUser() {
    Account account = repo.findById(1).get();
    Role roleEditor = entityManager.find(Role.class, 2);
    account.addRole(roleEditor);
  }

  @Test
  public void testRemoveRoleFromExistingUser() {
    Account account = repo.findById(1).get();
    Role role = new Role(2);
    account.removeRole(role);
  }

  @Test
  public void testCreateNewAccountWithNewRole() {
    Role roleSalesPerson = new Role("SalesPerson");
    Account account = new Account("sales.person@gmail.com", "1234", "");
    account.addRole(roleSalesPerson);

    repo.save(account);
  }

  @Test
  public void testGetAccount() {
    Account account = repo.findById(1).get();
    entityManager.detach(account);
    System.out.println(account.getEmail());
    System.out.println(account.getRoles());
  }

  @Test
  public void testRemoveAccount() {
    repo.deleteById(3);
  }
}
