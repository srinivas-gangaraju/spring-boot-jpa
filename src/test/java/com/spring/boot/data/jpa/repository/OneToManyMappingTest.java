package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Address;
import com.spring.boot.data.jpa.entity.Order;
import com.spring.boot.data.jpa.entity.OrderItem;
import com.spring.boot.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    //save order along with also save it's order items
    @Test
    void saveOrderMethod(){

    Order order = new Order();
    order.setOrderTrackingNumber("100ABC");
    order.setStatus("IN PROGRESS");


        //create order item 1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(1L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice((orderItem1.getProduct().getPrice().multiply(new BigDecimal(2))));
        orderItem1.setImageUrl("image1.png");
        //set order item to the order object
        order.getOrderItems().add(orderItem1);

        //create order item 2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice((orderItem2.getProduct().getPrice().multiply(new BigDecimal(3))));
        orderItem2.setImageUrl("image1.png");
        //set order item to the order object
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);


        Address address = new Address();

        address.setCity("Hyderabad");
        address.setStreet("Moula-Ali");
        address.setState("Telangana");
        address.setCountry("India");
        address.setZipCode("500040");
        //set address object to order
        order.setBillindAddress(address);
        //cascade save to order, orderItem and address tables
        orderRepository.save(order);
    }

    @Test
    void fetchOrderMethod(){
        Order order  = orderRepository.findById(1L).get();
        System.out.println(order);
        System.out.println(order.getStatus());
        order.getOrderItems().forEach(orderItem -> System.out.println(orderItem.getProduct().getName()));

    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(1L);
    }
}
