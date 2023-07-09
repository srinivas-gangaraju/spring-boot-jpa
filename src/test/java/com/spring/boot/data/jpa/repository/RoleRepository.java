package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoleRepository extends JpaRepository<Role, Long> {
}

