package com.monchisfrozenfood.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_cost", nullable = false)
    private Long productCost;

    @ManyToOne
    @JoinColumn(name ="fk_product_sub_category_id", referencedColumnName = "product_sub_category_id", nullable = false)
    private Long fkProductSubCategoryId;
}
