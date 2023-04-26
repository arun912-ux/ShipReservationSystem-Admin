package com.example.shipreservationsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data @Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "route-details")
public class RouteDetails {

    @Id
    @GeneratedValue
    private Long rid;

    private String source;

    private String destination;

    private double distance;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ShipDetails.class)
    @JoinColumn(name = "ships_fk", referencedColumnName = "rid")
    private List<ShipDetails> ships;

    public RouteDetails(String source, String destination, double distance, List<ShipDetails> ships) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.ships = ships;
    }

    @Override
    public String toString() {
        return "RouteDetails{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", ships=" + ships +
                '}';
    }
}
