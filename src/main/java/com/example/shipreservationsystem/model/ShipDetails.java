package com.example.shipreservationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@Setter @Getter @SuperBuilder @ToString
@Entity
@Table(name = "ship-details")
public class ShipDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sd_id;
    private String sname;
    private String model;
    private int capacity;

    @ManyToMany(mappedBy = "ships")
    @JsonIgnore
    @ToString.Exclude
    private Set<RouteDetails> routes;



    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "schedules_ships",
            joinColumns = {@JoinColumn(name = "ship_id")},
            inverseJoinColumns = { @JoinColumn(name = "schedule_id") }
    )
    @ToString.Exclude
    private Set<ShipSchedule> schedules;




    public ShipDetails(String sname, String model, int capacity, Set<RouteDetails> route, Set<ShipSchedule> schedules) {
        this.sname = sname;
        this.model = model;
        this.capacity = capacity;
        this.schedules = schedules;
    }
}
