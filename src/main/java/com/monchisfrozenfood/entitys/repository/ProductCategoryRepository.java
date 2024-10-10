package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
