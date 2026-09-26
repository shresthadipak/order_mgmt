package com.ordermgmt.order_mgmt.config;

import com.ordermgmt.order_mgmt.entities.Users;
import com.ordermgmt.order_mgmt.repositories.UsersRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadInitialData(UsersRepo usersRepo, PasswordEncoder passwordEncoder){
        return args -> {
            if (!usersRepo.existsByUsername("Admin")) {
                Users users = new Users();
                users.setUsername("Admin");
                users.setPassword(passwordEncoder.encode("p@ssw0rd"));
                users.setActive(true);
                usersRepo.save(users);
            }
        };
    }

}
