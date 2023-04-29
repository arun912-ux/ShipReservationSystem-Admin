package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.model.RoutesShipsSchedulesDTO;
import com.example.shipreservationsystem.model.ShipDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteDetailsRepository extends JpaRepository<RouteDetails, Long> {

//    @Query("select ships from RouteDetails where destination='' and source='' )

//    @Query ("select rd,sd,ss from RouteDetails rd join ShipDetails sd on rd.rid=sd.ships_fk join ShipSchedule ss on sd.sid where rd.source=:source and rd.destination=:destination")
//    List<RoutesShipsSchedulesDTO> findScheduleForGivenSourceDestinationAndDateTime(String source, String destination);


//    List<RouteDetails> findRouteDetailsBySourceAndDestination(String source, String destination);



}
