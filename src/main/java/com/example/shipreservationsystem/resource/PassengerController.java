package com.example.shipreservationsystem.resource;

import com.example.shipreservationsystem.model.PassengerProfile;
import com.example.shipreservationsystem.ro.ResponseRO;
import com.example.shipreservationsystem.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/getallpassengers")
    public ResponseEntity<ResponseRO> getAllPassengers(){
        List<PassengerProfile> allPassengers = passengerService.getAllPassengers();

        return ResponseEntity.ok(ResponseRO.builder()
                .httpStatus(HttpStatus.OK)
                .message("Success")
                .timeStamp(LocalDateTime.now())
                .data(Map.of("List<PassengerProfile>", allPassengers))
                .build()
        );
    }

    @GetMapping("/passenger/{id}")
    public ResponseEntity<Object> getPassengerById(@PathVariable Long id){
        return ResponseEntity.ok().body(passengerService.getPassengerFromId(id));
    }

}
