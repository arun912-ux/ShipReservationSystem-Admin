package com.example.shipreservationsystem.resource;


import com.example.shipreservationsystem.model.ShipSchedule;
import com.example.shipreservationsystem.ro.ResponseRO;
import com.example.shipreservationsystem.service.ScheduleService;
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
@RequestMapping("/schedules")
public class ScheduleController {



    private final ScheduleService scheduleService;


    // get all schedules details from db
    @GetMapping({"/details", "/details/"})
    public ResponseEntity<ResponseRO> allSchedules() {
        List<ShipSchedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(ResponseRO.builder()
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .message("All Schedules retrieved")
                .data(Map.of("all-schedule-details", schedules))
                .build()
        );
    }


    // get a schedules details from id
    @GetMapping("/details/{id}")
    public ResponseEntity<ResponseRO> getSchedulesDetailsById(@PathVariable Long id){
        ShipSchedule schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("schedule " + id + " details")
                .data(Map.of("schedule " + id , schedule))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .build()
        );
    }




    // add a new schedule to table
    @PostMapping("/details/new")
    public ResponseEntity<ResponseRO> newShipSchedule(@RequestBody ShipSchedule shipSchedule){
        ShipSchedule saved = scheduleService.insertNewShipSchedule(shipSchedule);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("new schedule added")
                .data(Map.of("schedule-details", saved))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build()
        );
    }


    // update a schedule with sch_id
    @PutMapping("/details/update/{id}")
    public ResponseEntity<ResponseRO> updateSchedule(@RequestBody ShipSchedule shipSchedule, @PathVariable Long id){
        ShipSchedule updated = scheduleService.updateScheduleDetails(shipSchedule, id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("route updated")
                .data(Map.of("route-details", updated))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(HttpStatus.ACCEPTED.value())
                .build()
        );
    }


    // delete a schedule details by id
    @DeleteMapping("/details/delete/{id}")
    public ResponseEntity<ResponseRO> deleteScheduleDetails(@PathVariable Long id){
        ShipSchedule deletedSchedule = scheduleService.deleteSchedule(id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("Schedule deleted")
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(HttpStatus.ACCEPTED.value())
                .data(Map.of("deleted Schedule Details", deletedSchedule))
                .timeStamp(LocalDateTime.now())
                .build()
        );

    }












    // assign passengers to schedule
    @PostMapping("/details/{sch_id}/passenger/{pas_id}")
    public ResponseEntity<ResponseRO> assignShipToRoute(@PathVariable Long sch_id, @PathVariable Long pas_id){
        ShipSchedule schedule = scheduleService.addPassengerToSchedule(sch_id, pas_id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("passenger added to schedule")
                .data(Map.of("schedule-details", schedule))
                .timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(202)
                .build()
        );
    }


    // delete passenger association from schedule
    @DeleteMapping("/details/{sch_id}/passenger/{pas_id}")
    public ResponseEntity<ResponseRO> removePassengerFromSchedule(@PathVariable Long sch_id, @PathVariable Long pas_id){
        ShipSchedule schedule = scheduleService.removePassengerFromSchedule(sch_id, pas_id);
        return ResponseEntity.ok(ResponseRO.builder()
                .message("removed passenger from schedule")
                .statusCode(202)
                .httpStatus(HttpStatus.ACCEPTED)
                .timeStamp(LocalDateTime.now())
                .data(Map.of("deleted-passenger-from-schedule", schedule))
                .build()
        );

    }







}
