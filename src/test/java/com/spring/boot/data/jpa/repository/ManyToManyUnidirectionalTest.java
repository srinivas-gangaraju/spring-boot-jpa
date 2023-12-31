package com.spring.boot.data.jpa.repository;


import com.spring.boot.data.jpa.entity.Role;
import com.spring.boot.data.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectionalTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser(){

        User user = new User();
        user.setFirstName("srinivas");
        user.setLastName("gangaraju");
        user.setEmail("srinivas@gmail.com");
        user.setPassword("secret");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

        user.getRole().add(admin);
        user.getRole().add(customer);

        userRepository.save(user);

    }

    @Test
    void updateUser(){
        User user = userRepository.findById(1L).get();
        user.setFirstName("ram");
        user.setEmail("ram@gmail.com");

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");

        user.getRole().add(roleUser);

        userRepository.save(user);
    }

    @Test
    void fetchUser(){
        User user = userRepository.findById(1L).get();

        System.out.println(user.getEmail());
        user.getRole().forEach((r) -> {
            System.out.println(r.getName());
        });

    }

    @Test
    void deleteUser(){
        userRepository.deleteById(1L);
    }
}
