package com.seanans.AirTickets.profile.services;

import com.seanans.AirTickets.profile.mappers.ProfileMapper;
import com.seanans.AirTickets.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileMapper profileMapper;
}
