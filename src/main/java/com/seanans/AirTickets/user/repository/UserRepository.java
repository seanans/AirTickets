package com.seanans.AirTickets.user.repository;

import com.seanans.AirTickets.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    User findByUsername(String username);
}
