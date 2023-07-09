package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Role;
import com.spring.boot.data.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class ManyToManyBidirectionMappingTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRole(){
        User user = new User();
        user.setFirstName("srinivas");
        user.setLastName("gangaraju");
        user.setEmail("srinivas@gmail.com");
        user.setPassword("secret");

        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");

        //add users to role
        roleAdmin.getUsers().add(user);
        roleAdmin.getUsers().add(admin);

        //add roles to users
        user.getRole().add(roleAdmin);
        admin.getRole().add(roleAdmin);


        roleRepository.save(roleAdmin);

    }

    @Test
    void fetchRole(){
        List<Role> roles = roleRepository.findAll();
        roles.forEach((r) -> {
            System.out.println(r.getName());
            r.getUsers().forEach((u) -> {
                System.out.println(u.getFirstName());
            });
        });
    }

    @Test
    void updateRole(){
        Role role = roleRepository.findById(4L).get();
        role.setName("SUPER_ADMIN");
        User user = new User();
        user.setEmail("superAdmin@gmail.com");
        role.getUsers().add(user);

        roleRepository.save(role);

    }

    @Test
    void deleteRole(){
        roleRepository.deleteById(4L);
    }
}
