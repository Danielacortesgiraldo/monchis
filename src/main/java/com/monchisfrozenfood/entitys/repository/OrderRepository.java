package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
