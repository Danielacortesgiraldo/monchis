package com.monchisfrozenfood.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_categories")
/* lombok */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "product_category_name", nullable = false)
    private String productCategoryName;
}
