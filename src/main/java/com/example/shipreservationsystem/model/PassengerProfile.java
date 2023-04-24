package com.example.shipreservationsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passenger-details")
@Getter @Setter @NoArgsConstructor
public class PassengerProfile {

    @Id
    @GeneratedValue
    private Long pid;

    private String name;


    public PassengerProfile(String name) {
        this.name = name;
    }
}
