package com.seanans.AirTickets.profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class ProfileEntity {
    @Id
    private UUID id;
}
