package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.PassengerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PassengerRepo extends JpaRepository<PassengerProfile, Long> {


}
