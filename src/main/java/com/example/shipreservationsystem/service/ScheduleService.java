package com.example.shipreservationsystem.service;

import com.example.shipreservationsystem.model.ShipSchedule;
import com.example.shipreservationsystem.repos.SchedulesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final SchedulesRepo schedulesRepo;


    public List<ShipSchedule> getAllSchedules() {
        return schedulesRepo.findAll();
    }

    public ShipSchedule getScheduleById(Long id) {
        return schedulesRepo.findById(id).orElseThrow(() -> new RuntimeException("404 Schedule ID not found"));
    }

    public ShipSchedule insertNewShipSchedule(ShipSchedule shipSchedule) {
        return schedulesRepo.save(shipSchedule);
    }

    public ShipSchedule updateScheduleDetails(ShipSchedule shipSchedule, Long id) {
        ShipSchedule schedule = schedulesRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule for given id not found"));
        schedule.setJourneyDate(shipSchedule.getJourneyDate());
        schedule.setSeatAvailability(shipSchedule.getSeatAvailability());
        return schedulesRepo.save(schedule);
    }

    public ShipSchedule deleteSchedule(Long id) {
        ShipSchedule schedule = schedulesRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule for given id not found"));
        schedulesRepo.delete(schedule);
        return schedule;
    }
}
