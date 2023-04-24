package com.example.shipreservationsystem.service;


import com.example.shipreservationsystem.model.PassengerProfile;
import com.example.shipreservationsystem.repos.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;

    public List<PassengerProfile> getAllPassengers() {
        return passengerRepo.findAll();
    }
}
