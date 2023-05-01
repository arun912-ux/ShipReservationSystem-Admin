package com.example.shipreservationsystem.ro;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;


@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
public class ResponseRO {

    private LocalDateTime timeStamp;
    private int statusCode;
    private HttpStatus httpStatus;
    private String message;
    private Map<?, ?> data;

}
