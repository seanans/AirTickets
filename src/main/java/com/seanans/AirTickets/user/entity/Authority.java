package com.seanans.AirTickets.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Authority {
    @Id
    private UUID id;
    private String name;
}
