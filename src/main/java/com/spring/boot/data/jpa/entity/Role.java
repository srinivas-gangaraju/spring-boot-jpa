package com.spring.boot.data.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    }, fetch = FetchType.EAGER, mappedBy = "role")
    private Set<User> users = new HashSet<>();

}
