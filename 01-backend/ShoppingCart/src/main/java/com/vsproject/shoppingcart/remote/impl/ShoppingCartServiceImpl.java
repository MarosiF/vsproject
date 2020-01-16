package com.vsproject.shoppingcart.remote.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vsproject.shoppingcart.jpa.ShoppingCartRepository;
import com.vsproject.shoppingcart.jpa.entity.ShoppingCart;
import com.vsproject.shoppingcart.remote.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository repository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.repository = shoppingCartRepository;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public ShoppingCart crateShoppingCart(ShoppingCart shoppingCart) {
        return repository.save(shoppingCart);
    }

    @HystrixCommand(fallbackMethod = "reliable2")
    @Override
    public List<ShoppingCart> findAll() {
        Iterable<ShoppingCart> entities = repository.findAll();
        ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
        entities.forEach(entry -> shoppingCartList.add(entry));
        return shoppingCartList;
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public List<ShoppingCart> findOne(Long id) {
        Iterable<ShoppingCart> entities = repository.findAll();
        ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
        entities.forEach(entry -> {
            if (entry.getId() == id) {
                shoppingCartList.add(entry);
            }
        });
            return shoppingCartList;
    }

        @Override
        public void delete (ShoppingCart shoppingCart){
            repository.delete(shoppingCart);
        }

        @Override
        public ResponseEntity<ShoppingCart> updateShoppingCart (ShoppingCart searchedShoppingCart){
            ShoppingCart shoppingCart = repository.findById(searchedShoppingCart.getId()).get();
            if(shoppingCart == null){
                return ResponseEntity.notFound().build();
            }
            shoppingCart.setProductId(searchedShoppingCart.getProductId());

            repository.deleteById(shoppingCart.getId());
            repository.save(shoppingCart);
            return ResponseEntity.ok(shoppingCart);
        }
    }
