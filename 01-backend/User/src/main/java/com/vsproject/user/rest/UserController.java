package com.vsproject.user.rest;


import com.vsproject.user.jpa.entity.User;
import com.vsproject.user.remote.UserService;
import org.hibernate.event.spi.PostCollectionRemoveEventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(this.userService.findOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id) {
        User user = userService.findOne(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userService.delete(user);

        return ResponseEntity.ok().body(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/shoppingcart/{userid}/{productid}/{amount}")
    public void createShoppingCart(@PathVariable(value = "userid") Long userid, @PathVariable(value = "productid") Long productid, @PathVariable(value = "amount") int amount) {
            userService.addShoppingCartEntry(userid,productid,amount);
    }


}
