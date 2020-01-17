package com.vsproject.shoppingcart.remote;

import com.vsproject.shoppingcart.jpa.entity.ShoppingCart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart crateShoppingCart(ShoppingCart shoppingCart);

    List<ShoppingCart> findAll();

    List<ShoppingCart> findGroup(Long userId);

    ShoppingCart findOne(Long id);

    void delete(ShoppingCart shoppingCart);

    ResponseEntity<ShoppingCart> updateShoppingCart(ShoppingCart shoppingCart);

    void createShoppingCartEntry(Long userid, Long productid, int amount);
}
