package com.ordermgmt.order_mgmt.repositories;

import com.ordermgmt.order_mgmt.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {

    Boolean existsByUsername(String username);

    Optional<Users> findByUsername(String username);

}
