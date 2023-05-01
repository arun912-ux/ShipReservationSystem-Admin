package com.example.shipreservationsystem.resource;

import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.ro.ResponseRO;
import com.example.shipreservationsystem.service.ShipDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/ships")
public class ShipController {


    private final ShipDetailsService shipDetailsService;

    // all ship details
    @GetMapping(value = "/details")
    public ResponseEntity<ResponseRO> getAllShipDetails() {

        List<ShipDetails> allShipDetails = shipDetailsService.getAllShipDetails();
        return ResponseEntity.ok(ResponseRO.builder()
                .message("all ships details")
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .data(Map.of("all-ships-details", allShipDetails))
                .build()
        );

    }


    // get a ship details by id
    @GetMapping(value = "/details/{id}")
    public ResponseEntity<ResponseRO> getShipDetailsById(@PathVariable("id") Long id){
//        return shipDetailsService.getShipDetailsById(id);
        ShipDetails retrievedShipDetails = shipDetailsService.getShipDetailsById(id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("ship "+ id + "details")
                .data(Map.of("ship "+ id + "details", retrievedShipDetails))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .build()
        );

    }

    @PostMapping(value = "/details/new")
    public ResponseEntity<ResponseRO> saveShipDetails(@RequestBody ShipDetails shipDetails){
        System.out.println(shipDetails);
        ShipDetails saveShipDetails = shipDetailsService.saveShipDetails(shipDetails);
        return ResponseEntity.ok(ResponseRO.builder()
                .statusCode(201)
                .httpStatus(HttpStatus.CREATED)
                .timeStamp(LocalDateTime.now())
                .message("new ship created ")
                .data(Map.of("ship created", saveShipDetails))
                .build()
        );
    }




    @PutMapping("/details/update/{id}")
    public ResponseEntity<ResponseRO> updateRouteDetails(@RequestBody ShipDetails shipDetails, @PathVariable Long id){
        ShipDetails updated = shipDetailsService.updateShipDetails(shipDetails, id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("ship updated")
                .data(Map.of("ship-details", updated))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(202)
                .build()
        );
    }


    // delete a route details by id
    @DeleteMapping("/details/delete/{id}")
    public ResponseEntity<ResponseRO> deleteRouteDetails(@PathVariable Long id){
        ShipDetails deletedShipDetails = shipDetailsService.deleteShipDetails(id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("Ship Details deleted")
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(202)
                .data(Map.of("deleted-ship-details", deletedShipDetails))
                .timeStamp(LocalDateTime.now())
                .build()
        );

    }








    // assign schedule to the ships
    @PostMapping("/details/{sd_id}/schedule/{sc_id}")
    public ResponseEntity<ResponseRO> assignScheduleToShips(@PathVariable Long sd_id, @PathVariable Long sc_id){

        ShipDetails shipDetails = shipDetailsService.addScheduleToShipByIds(sd_id, sc_id);

        return ResponseEntity.ok(ResponseRO.builder()
                .message("Schedule added to Ship")
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(HttpStatus.ACCEPTED.value())
                .data(Map.of("ship-schedule-details", shipDetails))
                .timeStamp(LocalDateTime.now())
                .build()
        );
    }



    @DeleteMapping("/details/{sd_id}/schedule/{sc_id}")
    public ResponseEntity<ResponseRO> removeScheduleAssociationFromShips(@PathVariable Long sd_id, @PathVariable Long sc_id){

        ShipDetails shipDetails = shipDetailsService.removeScheduleFromShip(sd_id, sc_id);

        return ResponseEntity.ok(ResponseRO.builder()
                .message("Schedule removed from Ship")
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(HttpStatus.ACCEPTED.value())
                .data(Map.of("ship-schedule-details", shipDetails))
                .timeStamp(LocalDateTime.now())
                .build()
        );
    }



}
