package com.amadich.acidorderconsumer.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int stock;

    @Version
    private Long version;

    public void decreaseStock() {
        if(stock <= 0){
            throw new RuntimeException("Out of stock");
        }
        stock--;
    }

}
