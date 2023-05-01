package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.RouteDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepo extends JpaRepository<RouteDetails, Long> {

//    @Query("select RouteDetails from RouteDetails where route_id=:id")
//    RouteDetails findRouteDetailsByShipId(Long id);

//    Object findRouteDetailsByShipssd_id(Long sd_id);

}
