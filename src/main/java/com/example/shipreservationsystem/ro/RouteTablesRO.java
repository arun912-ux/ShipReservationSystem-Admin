package com.example.shipreservationsystem.ro;

import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class RouteTablesRO {

    private String source;
    private String destination;
    private String sname;
    private String model;
    private LocalDateTime datetime;

}
