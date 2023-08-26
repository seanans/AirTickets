package com.seanans.AirTickets.user.mappers;

import com.seanans.AirTickets.user.entity.UserEntity;
import com.seanans.AirTickets.user.models.UserRegistrationDTO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    UserEntity userRegToUserentity(UserRegistrationDTO userRegistrationDTO);
}
