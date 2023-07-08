package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLIndexParam("laptop", "macbook");
        System.out.println(product);
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("notebook", "classmate notebook");
        System.out.println(product);
    }

}
