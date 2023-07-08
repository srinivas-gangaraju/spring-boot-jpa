package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedNativeSQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedNativeSqlQuery(){
        Product product = productRepository.findByDescription("Sony PS 5");
        System.out.println(product);
    }

    @Test
    void namedNativeSqlQueries(){
        Product product = productRepository.findByDescription("Sony PS 5");
        System.out.println(product);

        List<Product> products = productRepository.findAllOrderByPriceAsc();

        products.forEach(System.out::println);
    }
}
