package com.gamingstore.repositories;

import com.gamingstore.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepositories extends CrudRepository<CartItem, Integer> {

}
