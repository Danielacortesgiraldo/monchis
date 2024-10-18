package com.monchisfrozenfood.entitys;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_sub_categories")
@Data
@Builder

public class ProductSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_sub_category_id")
    private Long productSubCategoryId;

    @Column(name = "product_sub_category_name", nullable = false)
    private String productSubCategoryName;

    @ManyToOne
    @JoinColumn(name = "fk_product_category_id", referencedColumnName = "product_category_id", nullable = false)
    private ProductCategory fkProductCategoryId;
}
