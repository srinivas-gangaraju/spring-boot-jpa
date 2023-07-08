package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod(){

        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("notebook","classmate notebook");
        System.out.println(product);
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam("laptop", "macbook");
        System.out.println(product);
    }


}
