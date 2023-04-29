package com.example.shipreservationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "passenger-details")
@Getter @Setter @NoArgsConstructor @ToString
public class PassengerProfile {

    @Id
    @GeneratedValue
    private Long pas_id;

    private String name;

    @ManyToMany(mappedBy = "passengers")
    @JsonIgnore
    @ToString.Exclude
    private Set<ShipSchedule> schedules;


    public PassengerProfile(String name) {
        this.name = name;
    }
}
