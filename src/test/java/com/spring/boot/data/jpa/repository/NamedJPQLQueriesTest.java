package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedJPQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery(){
        Product product = productRepository.findByPrice(new BigDecimal(250));

        System.out.println(product);
    }

    @Test
    void namedJPQLQueries(){
        List<Product> products = productRepository.findAllOrderByNameDesc();

        products.forEach(System.out::println);

        Product product = productRepository.findByPrice(new BigDecimal(350));

        System.out.println(product);
    }
}
