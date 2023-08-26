package com.seanans.AirTickets.user.services;

import com.seanans.AirTickets.exception.ResourceBadRequestException;
import com.seanans.AirTickets.user.entity.RoleEntity;
import com.seanans.AirTickets.user.entity.UserEntity;
import com.seanans.AirTickets.user.mappers.UserMapper;
import com.seanans.AirTickets.user.models.UserRegistrationDTO;
import com.seanans.AirTickets.user.repository.RoleRepository;
import com.seanans.AirTickets.user.repository.UserRepository;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import com.seanans.AirTickets.ticket.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static final String UUID_IS_REQUIRED = "UUID is required";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TicketsService ticketsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TicketDTO orderTicket(UUID id) {
        if (id == null) {
            throw new ResourceBadRequestException(UUID_IS_REQUIRED);
        }
        TicketDTO ticketDTO = ticketsService.getTicketById(id);


        return null;
    }

    @Override
    public HttpStatus userRegistration(UserRegistrationDTO userRegistrationDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegistrationDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        userEntity.getRoleEntities().add(roleRepository.findByName("USER"));
        userRepository.save(userEntity);
        return HttpStatus.CREATED;
    }
}
