package com.example.shipreservationsystem.service;


import com.example.shipreservationsystem.model.PassengerProfile;
import com.example.shipreservationsystem.repos.PassengerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {


    private final PassengerRepo passengerRepo;

    public List<PassengerProfile> getAllPassengers() {
        return passengerRepo.findAll();
    }
    public PassengerProfile getPassengerFromId(Long id){
        return passengerRepo.findById(id).orElseThrow(() -> new RuntimeException("Passenger Not Found Exception"));
    }

    public PassengerProfile insertNewPassenger(PassengerProfile passengerProfile) {
        return passengerRepo.save(passengerProfile);
    }

    public PassengerProfile updatePassengerDetails(PassengerProfile passengerProfile, Long id) {
        PassengerProfile passenger = passengerRepo.findById(id).orElseThrow(() -> new RuntimeException("Passenger Not Found Exception"));
        passenger.setName(passengerProfile.getName());

        return passenger;
    }

    public PassengerProfile deletePassenger(Long id) {
        PassengerProfile passengerProfile = passengerRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Passenger Not Found Exception"));
        passengerRepo.delete(passengerProfile);
        return passengerProfile;
    }
}
