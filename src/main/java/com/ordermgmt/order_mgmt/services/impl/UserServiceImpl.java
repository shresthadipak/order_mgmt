package com.ordermgmt.order_mgmt.services.impl;

import com.ordermgmt.order_mgmt.entities.Users;
import com.ordermgmt.order_mgmt.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username"));

        return User.withUsername(users.getUsername())
                .password(users.getPassword())
                .disabled(!users.getActive())
                .build();
    }

}
