package com.vsproject.shoppingcart.rest;

import com.vsproject.shoppingcart.jpa.entity.ShoppingCart;
import com.vsproject.shoppingcart.remote.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService service) {
        this.shoppingCartService = service;
    }

    @PostMapping("shoppingcart")
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return this.shoppingCartService.crateShoppingCart(shoppingCart);
    }

    @GetMapping("shoppingcart")
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCart() {
        return new ResponseEntity<>(this.shoppingCartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("shoppingcart/user/{userid}")
    public ResponseEntity<List<ShoppingCart>> getShoppingCartByUserId(@PathVariable(value = "userid") Long shoppingCartId) {
        return new ResponseEntity<>(this.shoppingCartService.findGroup(shoppingCartId), HttpStatus.OK);
    }

    @GetMapping("shoppingcart/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(this.shoppingCartService.findOne(id), HttpStatus.OK);
    }

    @DeleteMapping("shoppingcart/{id}")
    public ResponseEntity<ShoppingCart> deleteShoppingCart(@PathVariable(value = "id") Long id) {
        ShoppingCart shoppingCart = shoppingCartService.findOne(id);
        if (shoppingCart == null) {
            return ResponseEntity.notFound().build();
        }
        shoppingCartService.delete(shoppingCart);

        return ResponseEntity.ok().body(shoppingCart);
    }

    @PutMapping("shoppingcart")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.updateShoppingCart(shoppingCart);
    }

    @PostMapping("users/shoppingcart/{userid}/{productid}/{amount}")
    public void createShoppingCartEntry(@PathVariable("userid") Long userid, @PathVariable("productid") Long productid, @PathVariable("amount") int amount) {
        shoppingCartService.createShoppingCartEntry(userid, productid,amount);
    }


}
