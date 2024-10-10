package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
