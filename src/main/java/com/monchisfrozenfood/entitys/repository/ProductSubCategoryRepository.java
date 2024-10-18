package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {

    @Query(value = "SELECT * FROM product_sub_categories", nativeQuery = true)
    List<ProductSubCategory> productSubCategoriesList();

    @Query(value = "SELECT * FROM product_sub_categories WHERE product_sub_category_id = :productSubCategoryId", nativeQuery = true)
    ProductSubCategory searchProductSubCategory(@Param("productSubCategoryId") Long productSubCategoryId);
}
