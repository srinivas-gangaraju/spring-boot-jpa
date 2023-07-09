package com.spring.boot.data.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//cannot use @Data annotation in case of bidirectional mapping. because it causes circular dependency due to the @ToString annotation
//use only getters and setters in this case or exclude to string annotation.
//@Data
@Getter
@Setter
@Entity
@Table(name = "product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private String categoryDescription;

    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,

    }, fetch = FetchType.LAZY, mappedBy = "productCategory")
    private List<Product> products = new ArrayList<>();


}
