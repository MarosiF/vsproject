package com.vsproject.shoppingcart.rest;

import com.vsproject.shoppingcart.jpa.entity.ShoppingCart;
import com.vsproject.shoppingcart.remote.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    public ShoppingCartController(ShoppingCartService service) {this.shoppingCartService = service;}

    @PostMapping("/add")
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {return this.shoppingCartService.crateShoppingCart(shoppingCart);}

    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCart() {return new ResponseEntity<>(this.shoppingCartService.findAll(), HttpStatus.OK);}

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<ShoppingCart>> getShoppingCartById(@PathVariable(value = "userid") Long shoppingCartId) {return new ResponseEntity<>(this.shoppingCartService.findGroup(shoppingCartId), HttpStatus.OK);}

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartByIdandProductId(@PathVariable (value = "id") Long id) {
        return new ResponseEntity<>(this.shoppingCartService.findOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingCart> deleteShoppingCart(@PathVariable(value = "id")Long id){
        ShoppingCart shoppingCart = shoppingCartService.findOne(id);
        if(shoppingCart == null) {
            return ResponseEntity.notFound().build();
        }
        shoppingCartService.delete(shoppingCart);

        return ResponseEntity.ok().body(shoppingCart);
    }

    @PutMapping("/update")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.updateShoppingCart(shoppingCart);
    }


}
