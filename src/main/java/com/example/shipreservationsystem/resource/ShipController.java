package com.example.shipreservationsystem.resource;

import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.model.ShipDetailsDTO;
import com.example.shipreservationsystem.service.ShipDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ShipController {

    @Autowired
    private ShipDetailsService shipDetailsService;

    @GetMapping(value = "/allshipdetails")
    public ResponseEntity<List<ShipDetails>> getAllShipDetails() {

        List<ShipDetails> allShipDetails = shipDetailsService.getAllShipDetails();
        return ResponseEntity.ok().body(allShipDetails);

    }

    @GetMapping(value = "/getShipdetails/{id}")
    public ShipDetails getShipDetailsById(@PathVariable("id") Long id){

        return shipDetailsService.getShipDetailsById(id);

    }

    @PostMapping(value = "/shipdetails")
        public ResponseEntity<ShipDetails> saveShipDetails(@RequestBody ShipDetailsDTO shipDetails){
        System.out.println(shipDetails);
        ShipDetails saveShipDetails = shipDetailsService.saveShipDetails(shipDetails.getShipDetails());
        return ResponseEntity.ok().body(saveShipDetails);
    }



}
