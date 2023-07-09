package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
