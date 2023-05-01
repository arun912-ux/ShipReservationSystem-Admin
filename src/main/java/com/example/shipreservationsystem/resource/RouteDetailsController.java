package com.example.shipreservationsystem.resource;

import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.ro.ResponseRO;
import com.example.shipreservationsystem.service.RouteDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;



@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/routes")
public class RouteDetailsController {

    private final RouteDetailsService routeDetailsService;


    // get all routes details from db
    @GetMapping({"/details", "/details/"})
    public ResponseEntity<ResponseRO> allRoutes() {
        List<RouteDetails> allRouteDetails = routeDetailsService.getAllRouteDetails();
        return ResponseEntity.ok(ResponseRO.builder()
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.OK)
                        .statusCode(200)
                        .message("Successful")
                        .data(Map.of("all-route-details", allRouteDetails))
                        .build()
                );
    }


    // get a route details from id
    @GetMapping("/details/{id}")
    public ResponseEntity<ResponseRO> getRouteDetailsById(@PathVariable Long id){
        RouteDetails retrievedRoute = routeDetailsService.getRouteDetailsById(id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message(String.valueOf("route " + id + " details"))
                .data(Map.of("route " + id , retrievedRoute))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .build()
        );
    }




    // get routes details for a specific source and destination and datetime
    @PostMapping(value = "/details/request")
    public ResponseEntity<ResponseRO> getRouteDetails(@RequestBody Map<?, ?> data){

//      System.out.println("inside getRouteDetails : " + (data.get("datetime").toString()) + " " + data.get("destination") + " " + data.get("source"));

      return ResponseEntity.ok(ResponseRO.builder()
              .timeStamp(LocalDateTime.now())
              .message("Successful")
              .httpStatus(HttpStatus.OK)
              .statusCode(200)
              .data(Map.of("Data", data))
              .build()
      );
    }



    // add a new route to table
    @PostMapping("/details/new")
    public ResponseEntity<ResponseRO> newRouteDetails(@RequestBody RouteDetails routeDetails){
        RouteDetails saved = routeDetailsService.insertNewRouteDetails(routeDetails);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("new route added")
                .data(Map.of("route-details", saved))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.CREATED)
                .statusCode(202)
                .build()
        );
    }



    // update a route details with route_id
    @PutMapping("/details/update/{id}")
    public ResponseEntity<ResponseRO> updateRouteDetails(@RequestBody RouteDetails routeDetails, @PathVariable Long id){
        RouteDetails updated = routeDetailsService.updateNewRouteDetails(routeDetails, id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("route updated")
                .data(Map.of("route-details", updated))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(201)
                .build()
        );
    }


    // delete a route details by id
    @DeleteMapping("/details/delete/{id}")
    public ResponseEntity<ResponseRO> deleteRouteDetails(@PathVariable Long id){
        RouteDetails deletedRouteDetails = routeDetailsService.deleteRouteDetails(id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("Route Details deleted")
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(201)
                .data(Map.of("deletedRouteDetails", deletedRouteDetails))
                .timeStamp(LocalDateTime.now())
                .build()
        );

    }




}
