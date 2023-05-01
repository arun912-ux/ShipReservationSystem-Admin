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




}
