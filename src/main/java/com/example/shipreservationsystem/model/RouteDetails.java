package com.example.shipreservationsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "route-details")
public class RouteDetails {

    @Id
    @GeneratedValue
    private Long rid;

    private String source;

    private String destination;

    private double distance;

    public RouteDetails(String source, String destination, double distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "RouteDetails{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                '}';
    }
}
