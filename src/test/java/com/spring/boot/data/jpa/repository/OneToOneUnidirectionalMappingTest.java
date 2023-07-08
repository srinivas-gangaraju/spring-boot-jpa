package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Address;
import com.spring.boot.data.jpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("1000ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();

        address.setCity("Hyderabad");
        address.setStreet("Moula-Ali");
        address.setState("Telangana");
        address.setCountry("India");
        address.setZipCode("500040");

        order.setBillindAddress(address);

        orderRepository.save(order);

    }


    @Test
    void updateOrderMethod(){

        Order order = orderRepository.findById(1L).get();
        order.setStatus("DELIVERED");
        order.getBillindAddress().setZipCode("500039");
        orderRepository.save(order);

    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(2L);
    }

    @Test
    void getOrderMethod(){
        Order order = orderRepository.findById(2L).get();

        System.out.println(order);
    }

}
