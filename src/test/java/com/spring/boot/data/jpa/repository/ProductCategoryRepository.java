package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
