package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("HP laptop");
        System.out.println(product);

    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();

        System.out.println(product);
    }
    @Test
    void findByNameOrDescriptionMethod(){

        List<Product> products = productRepository.findByNameOrDescription("HP laptop", "hp laptop");
        products.forEach(System.out::println);
    }

    @Test
    void findByNameAndDescriptionMethod(){

        List<Product> products = productRepository.findByNameAndDescription("HP laptop", "hp laptop");
        products.forEach(System.out::println);
    }
    @Test
    void findDistinctByNameMethod(){

        Product product = productRepository.findDistinctByName("HP laptop");

        System.out.println(product);
    }

    @Test
    void findByPriceGreaterThanMethod(){
       List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));

       products.forEach(System.out::println);
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(400));

        products.forEach(System.out::println);
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products = productRepository.findByNameContaining("book");

        products.forEach(System.out::println);

    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("book");
        products.forEach(System.out::println);
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(200), new BigDecimal(300));
        products.forEach(System.out::println);
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        //star tDate
        LocalDateTime startDate = LocalDateTime.of(2023, 7, 6, 20, 40, 27);
        //end date

        LocalDateTime endDate = LocalDateTime.of(2023, 7, 6, 22, 0, 0);
        //between dates records
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach(System.out::println);
    }
    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("Notebook","Macbook"));

        System.out.println(products);

    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach(System.out::println);
    }

    @Test
    void findTop3ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();
        products.forEach(System.out::println);
    }

    @Test
    void findTop3ByOrderByPriceAscMethod(){
        List<Product> products = productRepository.findTop3ByOrderByPriceAsc();
        products.forEach(System.out::println);
    }
}
