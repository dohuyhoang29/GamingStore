package com.gamingstore;

import com.gamingstore.model.Account;
import com.gamingstore.model.CartItem;
import com.gamingstore.model.Product;
import com.gamingstore.repositories.CartItemRepositories;
import java.util.List;
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
  public void testAddItemFromDatabase() {
    Product product = entityManager.find(Product.class, 1);
    Account account = entityManager.find(Account.class, 1);

    CartItem item = new CartItem(1, product, account);

    repo.save(item);
  }

  @Test
  public void testAddItemByIds() {
    Product product = new Product(3);
    Account account = new Account(2);
    CartItem item = new CartItem(2, product, account);

    repo.save(item);
  }

  @Test
  public void testAddMultipleItems() {
    Account account = new Account(1);
    Product product1 = new Product(1);
    Product product2 = new Product(2);
    Product product3 = new Product(3);

    CartItem item1 = new CartItem(1, product1, account);
    CartItem item2 = new CartItem(4, product2, account);
    CartItem item3 = new CartItem(5, product3, account);

    repo.saveAll(List.of(item1, item2, item3));
  }

  @Test
  public void testListItems() {
    Iterable<CartItem> listItems = repo.findAll();

    listItems.forEach(System.out::println);
  }

  @Test
  public void testUpdateItems() {
    CartItem item = repo.findById(1).get();
    item.setQuantity(10);
    item.setProduct(new Product(3));
  }

  @Test
  public void testDeleteItems() {
    repo.deleteById(1);
  }
}
 