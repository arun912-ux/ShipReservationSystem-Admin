package com.example.shipreservationsystem.resource;

import com.example.shipreservationsystem.model.PassengerProfile;
import com.example.shipreservationsystem.ro.ResponseRO;
import com.example.shipreservationsystem.service.PassengerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    @GetMapping("/details")
    public ResponseEntity<ResponseRO> getAllPassengers(){

        List<PassengerProfile> passengers = passengerService.getAllPassengers();

        return ResponseEntity.ok(ResponseRO.builder()
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("All Passengers Details")
                .timeStamp(LocalDateTime.now())
                .data(Map.of("all-passengers", passengers))
                .build()
        );
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Object> getPassengerById(@PathVariable Long id){
        PassengerProfile passenger = passengerService.getPassengerFromId(id);
        return ResponseEntity.ok(ResponseRO.builder()
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Passenger " + id + " details")
                .data(Map.of("passenger", passenger))
                .timeStamp(LocalDateTime.now())
                .build()
        );
    }




    // add a new passenger to table
    @PostMapping("/details/new")
    public ResponseEntity<ResponseRO> newPassenger(@RequestBody PassengerProfile passengerProfile){
        PassengerProfile saved = passengerService.insertNewPassenger(passengerProfile);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("new passenger added")
                .data(Map.of("passenger-details", saved))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build()
        );
    }


    // update a passenger with sch_id
    @PutMapping("/details/update/{id}")
    public ResponseEntity<ResponseRO> updatePassenger(@RequestBody PassengerProfile passengerProfile, @PathVariable Long id){
        PassengerProfile updated = passengerService.updatePassengerDetails(passengerProfile, id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("passenger updated")
                .data(Map.of("passenger-details", updated))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(HttpStatus.ACCEPTED.value())
                .build()
        );
    }


    // delete a passenger details by id
    @DeleteMapping("/details/delete/{id}")
    public ResponseEntity<ResponseRO> deletePassenger(@PathVariable Long id){
        PassengerProfile passenger = passengerService.deletePassenger(id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("Passenger deleted")
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(HttpStatus.ACCEPTED.value())
                .data(Map.of("deleted Passenger Details", passenger))
                .timeStamp(LocalDateTime.now())
                .build()
        );

    }







}
