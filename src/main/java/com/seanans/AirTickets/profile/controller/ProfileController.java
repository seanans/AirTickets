package com.seanans.AirTickets.profile.controller;

import com.seanans.AirTickets.profile.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileController {
    @Autowired
    private ProfileService profileService;
}
