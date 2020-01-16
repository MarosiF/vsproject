package com.vsproject.coffeecatproducts.remote.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vsproject.coffeecatproducts.jpa.ProductRepository;
import com.vsproject.coffeecatproducts.jpa.entity.Product;
import com.vsproject.coffeecatproducts.remote.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @HystrixCommand(fallbackMethod = "reliable2")
    @Override
    public List<Product> findAll() {
        Iterable<Product> entitites = repository.findAll();
        ArrayList<Product>  productList = new ArrayList<Product>();
        entitites.forEach(artikel -> productList.add(artikel));
        return productList;
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public Product findOne(Long id) {
        return repository.findById(id).get();
    }

    @HystrixCommand(fallbackMethod = "reliable4")
    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product searchedProduct) {
        Product product = repository.findById(searchedProduct.getId()).get();

        if(product == null){
            return ResponseEntity.notFound().build();
        }
        product.setCategory(searchedProduct.getCategory());
        product.setSku(searchedProduct.getSku());
        product.setName(searchedProduct.getName());
        product.setDescription(searchedProduct.getDescription());
        product.setUnitPrice(searchedProduct.getUnitPrice());
        product.setImageUrl(searchedProduct.getImageUrl());
        //product.setActive(searchedProduct.getActive());
        product.setUnitsInStock(searchedProduct.getUnitsInStock());
        product.setDateCreated(searchedProduct.getDateCreated());
        product.setLastUpdated(searchedProduct.getLastUpdated());

        repository.deleteById(product.getId());
        repository.save(product);

        return ResponseEntity.ok(product);
    }
}
