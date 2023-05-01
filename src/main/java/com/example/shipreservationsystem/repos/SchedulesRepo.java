package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.ShipSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepo extends JpaRepository<ShipSchedule, Long> {



}
