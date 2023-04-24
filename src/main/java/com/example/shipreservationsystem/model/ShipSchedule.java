package com.example.shipreservationsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "ship-schedule")
public class ShipSchedule {

    @Id
    @GeneratedValue
    private Long sid;
    private LocalDateTime journeyDate;

    private Integer seatAvailability;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = PassengerProfile.class)
    @JoinColumn(name = "passenger_fk", referencedColumnName = "sid")
    private List<PassengerProfile> passengers;

    public ShipSchedule(LocalDateTime journeyDate, Integer seatAvailability, List<PassengerProfile> passengers) {
        this.journeyDate = journeyDate;
        this.seatAvailability = seatAvailability;
        this.passengers = passengers;
    }
}
