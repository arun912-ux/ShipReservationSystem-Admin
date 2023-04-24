package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.ShipDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipDetailsRepo extends JpaRepository<ShipDetails, Long> {



}
