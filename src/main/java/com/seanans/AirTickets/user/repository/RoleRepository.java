package com.seanans.AirTickets.user.repository;

import com.seanans.AirTickets.user.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    RoleEntity findByName(String name);
}
