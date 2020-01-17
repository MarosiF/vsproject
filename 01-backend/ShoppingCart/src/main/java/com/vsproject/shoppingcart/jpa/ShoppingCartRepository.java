package com.vsproject.shoppingcart.jpa;


import com.vsproject.shoppingcart.jpa.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
