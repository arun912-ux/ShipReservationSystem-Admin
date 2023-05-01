package com.example.shipreservationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;


@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "route-details")
public class RouteDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long route_id;

    private String source;

    private String destination;

    private double distance;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "routes_ships",
            joinColumns = {@JoinColumn(name = "route_id")},
            inverseJoinColumns = { @JoinColumn(name = "ship_id") }
    )
    @ToString.Exclude
    @JsonIgnore
    private Set<ShipDetails> ships;





    public RouteDetails(String source, String destination, double distance, Set<ShipDetails> ships) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.ships = ships;
    }










    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RouteDetails that = (RouteDetails) o;
        return getRoute_id() != null && Objects.equals(getRoute_id(), that.getRoute_id());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
