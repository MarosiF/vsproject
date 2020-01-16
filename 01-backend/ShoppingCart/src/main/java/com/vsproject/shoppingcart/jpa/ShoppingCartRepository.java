package com.vsproject.shoppingcart.jpa;


import com.vsproject.shoppingcart.jpa.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
