package com.vsproject.user.remote;

import com.vsproject.user.jpa.entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> findAll();

    User findOne(Long id);

    void delete(User user);

    ResponseEntity<User> updateUser(User user);

    //one-way call to shoppingcart
    void addShoppingCartEntry(Long userid, Long productid, int amount);
}
