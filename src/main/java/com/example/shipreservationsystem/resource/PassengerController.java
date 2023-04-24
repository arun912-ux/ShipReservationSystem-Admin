package com.example.shipreservationsystem.resource;

import com.example.shipreservationsystem.model.PassengerProfile;
import com.example.shipreservationsystem.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/getallpassengers")
    public ResponseEntity<List<PassengerProfile>> getAllPassengers(){
        List<PassengerProfile> allPassengers = passengerService.getAllPassengers();
        return ResponseEntity.ok().body(allPassengers);
    }

}
