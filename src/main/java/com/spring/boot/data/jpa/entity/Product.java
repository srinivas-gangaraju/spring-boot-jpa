package com.spring.boot.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_unique", columnNames = "stock_keeping_unit")
//                @UniqueConstraint(name = "name_unique", columnNames = "name")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries(
        {
                @NamedQuery(
                        name ="Product.findAllOrderByNameDesc",
                        query="SELECT p from Product p ORDER BY p.name DESC"
                ),

                @NamedQuery(
                        name ="Product.findByPrice",
                        query="SELECT p from Product p WHERE p.price = :price"
                )
        }
)
@NamedNativeQueries(
        {
                @NamedNativeQuery(

                        name= "Product.findByDescription",
                        query = "SELECT * from products p where p.description= :description",
                        resultClass = Product.class
                ),

                @NamedNativeQuery(

                        name= "Product.findAllOrderByPriceAsc",
                        query = "SELECT * from products p order by price asc",
                        resultClass = Product.class
                ),

        }
)
//@NamedNativeQuery(
//        name= "Product.findByDescription",
//        query = "SELECT * from products p where p.description= :description",
//        resultClass = Product.class
//)
//@NamedQuery(name = "Product.findByPrice",
//query = "SELECT p from Product p where p.price = :price")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize =  1
    )
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;

    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

}
