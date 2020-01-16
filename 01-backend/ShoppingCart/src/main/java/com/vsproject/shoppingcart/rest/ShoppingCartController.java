package com.vsproject.shoppingcart.rest;

import com.vsproject.shoppingcart.jpa.entity.ShoppingCart;
import com.vsproject.shoppingcart.remote.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    public ShoppingCartController(ShoppingCartService service) {this.shoppingCartService = service;}

    @PostMapping("/shoppingCart/add")
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {return this.shoppingCartService.crateShoppingCart(shoppingCart);}

    @GetMapping("/shoppingCart/all")
    public List<ShoppingCart> getAllShoppingCart() {return this.shoppingCartService.findAll();}

    @GetMapping("/shoppingCart/{id}")
    public List<ShoppingCart> getShoppingCartById(@PathVariable(value = "id") Long shoppingCartId) {return this.shoppingCartService.findOne(shoppingCartId);}

    @DeleteMapping("/shoppingCart/{id}{productId}")
    public ResponseEntity<List<ShoppingCart>> deleteShoppingCart(@PathVariable(value = "id")Long shoppingCartId, @PathVariable(value = "productId")Long shoppingCartProductId){
        Iterable<ShoppingCart> shoppingCart = shoppingCartService.findOne(shoppingCartId);
        ArrayList<ShoppingCart> deleteItems = new ArrayList<>();
        shoppingCart.forEach(entry -> {if(entry.getProductId() == shoppingCartProductId){
        deleteItems.add(entry);}
        });

        if(deleteItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        deleteItems.forEach(shoppingCartService::delete);

        return ResponseEntity.ok().body(deleteItems);
    }

    @PutMapping("/shoppingCart/delete")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.updateShoppingCart(shoppingCart);
    }
}
