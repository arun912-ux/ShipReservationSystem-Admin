package com.example.shipreservationsystem.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Setter @Getter @SuperBuilder
@Entity
@Table(name = "ship-details")
public class ShipDetails {

    @Id
    @GeneratedValue
    private Long sid;
    private String sname;
    private String model;
    private int capacity;


    @OneToMany(cascade = CascadeType.ALL, targetEntity = ShipSchedule.class)
    @JoinColumn(name = "schedule_fk", referencedColumnName = "sid")
    private List<ShipSchedule> schedule;


    @Override
    public String toString() {
        return "ShipDetails{" +
                "sname='" + sname + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", schedule=" + schedule +
                '}';
    }

    public ShipDetails(String sname, String model, int capacity, List<RouteDetails> route, List<ShipSchedule> schedule) {
        this.sname = sname;
        this.model = model;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}
