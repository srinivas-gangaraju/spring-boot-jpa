package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {


}
