package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


    Order findByOrderTrackingNumber(String orderTrackingNumber);

}
