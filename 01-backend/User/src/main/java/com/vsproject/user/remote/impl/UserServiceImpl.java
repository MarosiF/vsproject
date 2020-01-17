package com.vsproject.user.remote.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vsproject.user.jpa.UserRepository;
import com.vsproject.user.jpa.entity.User;
import com.vsproject.user.remote.UserService;
import com.vsproject.user.remote.rest.ShoppingCartClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    private final ShoppingCartClient shoppingCartClient;

    public UserServiceImpl(UserRepository userRepository, ShoppingCartClient shoppingCartClient) {
        this.repository = userRepository;
        this.shoppingCartClient = shoppingCartClient;
    }


    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public User createUser(User user) {
        return this.repository.save(user);
    }

    @HystrixCommand(fallbackMethod = "reliable2")
    @Override
    public List<User> findAll() {
        Iterable<User> entities = repository.findAll();
        ArrayList<User> users = new ArrayList<>();
        entities.forEach(entry -> users.add(entry));
        return users;
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public User findOne(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @HystrixCommand(fallbackMethod = "reliable4")
    @Override
    public ResponseEntity<User> updateUser(User searchedUser) {
        User user = repository.findById(searchedUser.getId()).get();
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setName(searchedUser.getName());
        user.setSurename(searchedUser.getSurename());

        repository.deleteById(user.getId());
        repository.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public void addShoppingCartEntry(Long userid, Long productid, int amount) {
        shoppingCartClient.createShoppingCartEntry(userid, productid, amount);
    }

    //resilience fallback

    public User reliable(User user) {
        User user1 = new User();
        user1.setName("default name");
        user1.setSurename("default surename");
        return user1;
    }

    public List<User> reliable2() {
        return new ArrayList<User>();
    }

    public User reliable3(Long id) {
        User u = new User();
        u.setName("default");
        u.setSurename("default");
        return u;
    }

    public ResponseEntity<User> reliable4(User user) {
        return ResponseEntity.notFound().build();
    }
}
