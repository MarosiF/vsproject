package com.vsproject.coffeecatproducts.remote;


import com.vsproject.coffeecatproducts.jpa.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product createProduct(Product product);

    List<Product> findAll();

    Product findOne(Long id);

    void delete(Product product);

    ResponseEntity<Product> updateProduct(Product product);
}
