package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import com.spring.boot.data.jpa.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory(){
        //create Product Category
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("books");
        productCategory.setCategoryDescription("books description");

        //create new Product
        Product product1 = new Product();
        product1.setName("Core Java");
        product1.setPrice(new BigDecimal(1000));
        product1.setImageUrl("image1.png");
        product1.setSku("ABCD");
        product1.setActive(true);
        product1.setProductCategory(productCategory);

        productCategory.getProducts().add(product1);



        //create new Product
        Product product2 = new Product();
        product2.setName("Effective Java");
        product2.setPrice(new BigDecimal(2000));
        product2.setImageUrl("image2.png");
        product2.setSku("ABCDE");
        product2.setActive(true);
        product2.setProductCategory(productCategory);

        productCategory.getProducts().add(product2);


        productCategoryRepository.save(productCategory);
    }

    @Test
    @Transactional
    void fetchProductCategory(){

        ProductCategory productCategory = productCategoryRepository.findById(1L).get();

        System.out.println(productCategory.getProducts());

    }
}