package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<Product> productsList();

    @Query(value = "SELECT * FROM products WHERE product_id = :productId", nativeQuery = true)
    Product searchProduct(@Param("productId") Long productId);
}
