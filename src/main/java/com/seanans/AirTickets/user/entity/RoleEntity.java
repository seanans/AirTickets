package com.seanans.AirTickets.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class RoleEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @ManyToMany(mappedBy = "roleEntities")
    private Set<UserEntity> users = new HashSet<>();

}
