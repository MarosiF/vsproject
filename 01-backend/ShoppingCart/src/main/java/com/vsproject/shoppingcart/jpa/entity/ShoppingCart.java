package com.vsproject.shoppingcart.jpa.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shoppingcart")
@Data
public class ShoppingCart {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "amount")
    private int amount;

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, Long user_id, Long product_id, int amount) {
        this();
        this.id = id;
        this.user_id = user_id;
        this.productId = product_id;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
