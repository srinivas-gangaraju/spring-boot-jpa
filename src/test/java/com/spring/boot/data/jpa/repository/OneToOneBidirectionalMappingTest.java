package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Address;
import com.spring.boot.data.jpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddressMethod(){

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

//        order.setBillindAddress(address);

        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void updateAddressMethod(){

        Address address = addressRepository.findById(1L).get();

        address.setZipCode("500039");
        address.getOrder().setStatus("DELIVERED");

        addressRepository.save(address);

    }

    @Test
    void fetchAddressMethod(){
        Address address = addressRepository.findById(1L).get();

    }

    @Test
    void deleteAddressMethod(){

        addressRepository.deleteById(1L);
    }


}
