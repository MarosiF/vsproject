package com.vsproject.shoppingcart.remote.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vsproject.shoppingcart.jpa.ShoppingCartRepository;
import com.vsproject.shoppingcart.jpa.entity.ShoppingCart;
import com.vsproject.shoppingcart.remote.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
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
    public List<ShoppingCart> findGroup(Long userId) {
        Iterable<ShoppingCart> entities = repository.findAll();
        ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
        entities.forEach(entry -> {
            if (entry.getUser_id() == userId) {
                shoppingCartList.add(entry);
            }
        });
            return shoppingCartList;
    }

    @HystrixCommand(fallbackMethod = "reliable4")
    @Override
    public ShoppingCart findOne(Long id) {
        ShoppingCart shoppingCart = null;
        Iterable<ShoppingCart> entities = repository.findAll();
        Iterator iter =entities.iterator();
        while(iter.hasNext()) {
            ShoppingCart searchedShoppingCart = (ShoppingCart) iter.next();
            if(searchedShoppingCart.getId() == id) {
                shoppingCart = searchedShoppingCart;
            }
        }
        return shoppingCart;

    }

        @Override
        public void delete (ShoppingCart shoppingCart){
            repository.delete(shoppingCart);
        }

        @HystrixCommand(fallbackMethod = "reliable5")
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

    //resilience fallback

    public ShoppingCart reliable(ShoppingCart shoppingCart){
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId(0);
        shoppingCart1.setProductId(0);
        return shoppingCart1;
    }

    public List<ShoppingCart> reliable2(){
        return new ArrayList<ShoppingCart>();
    }

    public List<ShoppingCart> reliable3(Long userid){
        return new ArrayList<ShoppingCart>();
    }

    public ShoppingCart reliable4(Long id) {
        return new ShoppingCart();
    }
    public ResponseEntity<ShoppingCart> reliable5(ShoppingCart searchedShoppingCart) {
        return ResponseEntity.notFound().build();
    }

    }
