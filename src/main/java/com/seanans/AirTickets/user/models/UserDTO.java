package com.seanans.AirTickets.user.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
}
