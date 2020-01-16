package com.vsproject.coffeecatproducts.rest;

import com.vsproject.coffeecatproducts.jpa.entity.Product;
import com.vsproject.coffeecatproducts.remote.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product")
    public Product createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }

    @GetMapping("product")
    public List<Product> getAllProduct(){
        return productService.findAll();
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Long productid){

        Product product = productService.findOne(productid);

        if(product == null){
            return ResponseEntity.notFound().build();
        }

        productService.delete(product);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productid){
        Product product = productService.findOne(productid);

        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @GetMapping("users/unitsInStock/{id}")
    public int getUnitsInStock(@PathVariable(value = "id") Long productId){
        return productService.findOne(productId).getUnitsInStock();
    }

}
