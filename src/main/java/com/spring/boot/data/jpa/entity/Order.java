package com.spring.boot.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;

    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
//    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billindAddress;


    //default fetch type for one to many to LAZY
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Set<OrderItem> orderItems = new HashSet<>();


    public BigDecimal getTotalAmount(){
//        BigDecimal amount = new BigDecimal(0);

        Optional<BigDecimal> amount = this.orderItems.stream().map(OrderItem::getPrice)
                .reduce(BigDecimal::add);
        return amount.get();
    }
}


