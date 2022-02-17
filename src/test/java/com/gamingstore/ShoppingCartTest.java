package com.gamingstore;

import com.gamingstore.model.Account;
import com.gamingstore.model.Product;
import com.gamingstore.repositories.CartItemRepositories;
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
public class ShoppingCartTest {
  @Autowired
  private CartItemRepositories repo;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void testAddItemFromDatabase () {
    Product product = entityManager.find(Product.class, 4);
    Account account = entityManager.find(Account.class, 4);
  }
}
