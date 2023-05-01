package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.PassengerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PassengerRepo extends JpaRepository<PassengerProfile, Long> {

//    @Query(
//            "select pp from RouteDetails rd join ShipDetails sd on rd.route_id  join ShipSchedule ss on sd.sd_id join PassengerProfile pp where pp.pas_id=:id"
//    )
//    Object findPassengerDetailsById(Long id);

}
