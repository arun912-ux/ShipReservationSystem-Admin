package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.ShipSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SchedulesRepo extends JpaRepository<ShipSchedule, Long> {



    @Modifying
    @Query(value = "delete from schedules_ships wHERE schedule_id= ?1",
                nativeQuery = true)
    void deleteForAssignedShipSchedule(Long id);
}
