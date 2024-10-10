package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
