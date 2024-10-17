package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    @Query(value = "SELECT * FROM product_categories", nativeQuery = true)
    List<ProductCategory> productCategoriesList();

    @Query(value = "SELECT * FROM product_categories WHERE product_category_id = :productCategoryId", nativeQuery = true)
    ProductCategory searchProductCategory(@Param("productCategoryId") Long productCategoryId);
}
