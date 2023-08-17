package com.seanans.AirTickets.profile.repository;

import com.seanans.AirTickets.profile.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {
}
