package com.example.shipreservationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "ship-schedule")
public class ShipSchedule {

    @Id
    @GeneratedValue
    private Long sch_id;
    private LocalDateTime journeyDate;

    private Integer seatAvailability;

    @ManyToMany(mappedBy = "schedules")
    @JsonIgnore
    @ToString.Exclude
    private Set<ShipDetails> ships;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "schedules_passengers",
            joinColumns = {@JoinColumn(name = "schedule_id")},
            inverseJoinColumns = { @JoinColumn(name = "passenger_id") }
    )
    @ToString.Exclude
    private Set<PassengerProfile> passengers;



    public ShipSchedule(LocalDateTime journeyDate, Integer seatAvailability, Set<PassengerProfile> passengers) {
        this.journeyDate = journeyDate;
        this.seatAvailability = seatAvailability;
        this.passengers = passengers;
    }
}
