package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.ro.RouteTablesRO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RouteDetailsRepo extends JpaRepository<RouteDetails, Long> {


    @Query(value = "select rd.source, rd.destination, sd.sname, sd.model, sss.journey_date from `route-details` rd " +
            " join routes_ships rs on rd.route_id = rs.route_id  " +
            "join `ship-details` sd on sd.sd_id = rs.ship_id  " +
            "join schedules_ships ss on sd.sd_id = ss.ship_id  " +
            "join `ship-schedule` sss on ss.schedule_id = sss.sch_id  " +
            "where rd.destination = :destination and rd.source = :source and :dateTime <= sss.journey_date ",
            nativeQuery = true)
    List<Object> findAllBySourceAndDestinationAndTime(String source, String destination, LocalDateTime dateTime);

}
