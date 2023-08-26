package com.seanans.AirTickets.config;

import com.seanans.AirTickets.user.entity.RoleEntity;
import com.seanans.AirTickets.user.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RolesDatabaseInitializer {
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        RoleEntity adminRole = new RoleEntity();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        RoleEntity userRole = new RoleEntity();
        userRole.setName("USER");
        roleRepository.save(userRole);
    }
}
