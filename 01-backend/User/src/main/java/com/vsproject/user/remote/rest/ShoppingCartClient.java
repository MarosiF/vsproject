package com.vsproject.user.remote.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ShoppingCart-Service")
public interface ShoppingCartClient {
    @PostMapping("users/shoppingcart/{userid}/{productid}/{amount}")
    void createShoppingCartEntry(@PathVariable(value = "userid") Long userid,
                     @PathVariable(value = "productid") Long productid,
                     @PathVariable(value = "amount") int amount);
}
