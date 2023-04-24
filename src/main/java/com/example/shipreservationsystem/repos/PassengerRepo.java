package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.PassengerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<PassengerProfile, Long> {
}
