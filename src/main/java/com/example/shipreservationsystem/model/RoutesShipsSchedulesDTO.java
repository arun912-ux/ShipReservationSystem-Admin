package com.example.shipreservationsystem.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @ToString

public class RoutesShipsSchedulesDTO {

    private String source;
    private String destination;
    private String sname;
    private int capacity;
    private LocalDateTime journey_date;


}
