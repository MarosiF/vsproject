package com.vsproject.user.remote;

import com.vsproject.user.jpa.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> findAll();

    User findOne(Long id);

    void delete(User user);

    ResponseEntity<User> updateUser(User user);
}
