package com.example.shipreservationsystem.service;

import com.example.shipreservationsystem.model.RouteDetails;
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

    public ShipDetails updateShipDetails(ShipDetails shipDetails, Long id) {
        ShipDetails oldShipDetails = shipDetailsRepo.findById(id).orElseThrow(() -> new RuntimeException("Ship Not Found Exception"));
        oldShipDetails.setSd_id(shipDetails.getSd_id());
        oldShipDetails.setCapacity(shipDetails.getCapacity());
        oldShipDetails.setModel(shipDetails.getModel());
        oldShipDetails.setSname(shipDetails.getSname());
        return shipDetailsRepo.save(oldShipDetails);
    }

    public ShipDetails deleteShipDetails(Long id) {
        ShipDetails shipDetails = shipDetailsRepo.findById(id).orElseThrow();
        shipDetailsRepo.delete(shipDetails);
        return shipDetails;
    }
}
