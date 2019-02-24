package com.edureka.jan26.mstraing.orderservice.respository;

import com.edureka.jan26.mstraing.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
