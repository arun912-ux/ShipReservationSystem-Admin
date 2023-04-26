package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.RouteDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDetailsRepository extends JpaRepository<RouteDetails, Long> {



}
