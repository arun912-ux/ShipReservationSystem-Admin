package com.example.shipreservationsystem.service;

import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.repos.ShipDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipDetailsService {

    @Autowired
    private ShipDetailsRepo shipDetailsRepo;

    public List<ShipDetails> getAllShipDetails() {

        return shipDetailsRepo.findAll();

    }

    public ShipDetails getShipDetailsById(Long id) {
        return shipDetailsRepo.findById(id).orElseThrow();
    }

    public ShipDetails saveShipDetails(ShipDetails shipDetails) {
        return shipDetailsRepo.save(shipDetails);
    }
}
