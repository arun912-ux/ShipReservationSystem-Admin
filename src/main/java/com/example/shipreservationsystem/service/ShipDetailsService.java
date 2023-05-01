package com.example.shipreservationsystem.service;

import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.model.ShipSchedule;
import com.example.shipreservationsystem.repos.SchedulesRepo;
import com.example.shipreservationsystem.repos.ShipDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ShipDetailsService {

    @Autowired
    private ShipDetailsRepo shipDetailsRepo;
    @Autowired
    private SchedulesRepo schedulesRepo;

    public List<ShipDetails> getAllShipDetails() {

        return shipDetailsRepo.findAll();

    }

    public ShipDetails getShipDetailsById(Long id) {
        return shipDetailsRepo.findById(id).orElseThrow(() -> new RuntimeException("Ship Id Not Found Exception"));
    }

    public ShipDetails saveShipDetails(ShipDetails shipDetails) {
        return shipDetailsRepo.save(shipDetails);
    }

    public ShipDetails updateShipDetails(ShipDetails shipDetails, Long id) {
        ShipDetails oldShipDetails = shipDetailsRepo.findById(id).orElseThrow(() -> new RuntimeException("Ship Not Found Exception"));
        oldShipDetails.setCapacity(shipDetails.getCapacity());
        oldShipDetails.setModel(shipDetails.getModel());
        oldShipDetails.setSname(shipDetails.getSname());
        return shipDetailsRepo.save(oldShipDetails);
    }

    public ShipDetails deleteShipDetails(Long id) {
        ShipDetails shipDetails = shipDetailsRepo.findById(id).orElseThrow(() -> new RuntimeException("Ship Not Found Exception"));
        shipDetailsRepo.delete(shipDetails);
        return shipDetails;
    }




    public ShipDetails addScheduleToShipByIds(Long sdId, Long scId) {
        ShipDetails shipDetails = shipDetailsRepo.findById(sdId).orElseThrow(() -> new RuntimeException("Ship Not Found Exception"));
        ShipSchedule schedule = schedulesRepo.findById(scId).orElseThrow(() -> new RuntimeException("Schedule Not Found Exception"));

        // check whether the schedule id is mapped to any other ships
        Set<ShipDetails> ships = schedule.getShips();
        boolean flag = true;
        if(! ships.isEmpty()){
            ships.forEach(System.out::println);
            for(ShipDetails sd : ships){
                if(sd.getSd_id() != sdId){
                    flag=false;
                    break;
                }
            }
        }

        if(flag) {
            shipDetails.getSchedules().add(schedule);
            shipDetailsRepo.save(shipDetails);
        }
        else{
            throw new RuntimeException("Schedule is already mapped to other ships");
        }

        return shipDetails;

    }



    public ShipDetails removeScheduleFromShip(Long sdId, Long scId) {
        ShipDetails shipDetails = shipDetailsRepo.findById(sdId).orElseThrow(() -> new RuntimeException("Ship Not Found Exception"));
        ShipSchedule schedule = schedulesRepo.findById(scId).orElseThrow(() -> new RuntimeException("Schedule Not Found Exception "));

        // 1st check whether the given ship is present in routes

        Set<ShipSchedule> schedules = shipDetails.getSchedules();

        boolean contains = schedules.contains(schedule);

        if(!contains){
            throw new RuntimeException("This Schedule is not assigned to this Ship");
        }else{
            shipDetails.getSchedules().remove(schedule);
            shipDetailsRepo.save(shipDetails);
        }

        return shipDetails;
    }

}
