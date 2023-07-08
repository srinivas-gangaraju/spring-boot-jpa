package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("laptop");
        product.setDescription("hp laptop");
        product.setSku("2020");
        product.setActive(true);
        product.setPrice(new BigDecimal(350));
        product.setImageUrl("product1.png");
        //save product
        Product saveObject = productRepository.save(product);
        //display product info
        System.out.println(saveObject.getId());
        System.out.println(saveObject);
    }

    @Test
    void updateUsingSaveMethod(){
        //find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity info
        product.setDescription("HP ENVY Laptop");
        //save update entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();


    }

    @Test
    void saveAllMethod(){
        //create product
        Product product1 = new Product();
        product1.setName("notebook");
        product1.setDescription("classmate notebook");
        product1.setSku("INDIA");
        product1.setActive(true);
        product1.setPrice(new BigDecimal(250));
        product1.setImageUrl("Eiffel-tower.png");

        //create product
        Product product2 = new Product();
        product2.setName("laptop");
        product2.setDescription("Macbook");
        product2.setSku("USA");
        product2.setActive(true);
        product2.setPrice(new BigDecimal(350));
        product2.setImageUrl("MacBook.png");


        //create product
        Product product3 = new Product();
        product3.setName("PlayStation");
        product3.setDescription("Sony PS 5");
        product3.setSku("England");
        product3.setActive(true);
        product3.setPrice(new BigDecimal(450));
        product3.setImageUrl("Twitch5.png");

        productRepository.saveAll(List.of(product3, product2, product1));
    }


    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();

        products.forEach(System.out::println);
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        Long id = 2L;
        //find an entity by id
        Product product = productRepository.findById(id).get();
        //delete(entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
//        productRepository.deleteAll();

        Product product = productRepository.findById(102L).get();
        Product product2 = productRepository.findById(103L).get();

        productRepository.deleteAll(List.of(product2, product));
    }

    @Test
    void countMethod(){

         long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        Long id = 202L;

        boolean exists = productRepository.existsById(id);

        System.out.println(exists);
    }

}