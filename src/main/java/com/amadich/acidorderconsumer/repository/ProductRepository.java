package com.amadich.acidorderconsumer.repository;

import com.amadich.acidorderconsumer.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
