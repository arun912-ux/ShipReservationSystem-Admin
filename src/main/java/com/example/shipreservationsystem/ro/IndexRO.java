package com.example.shipreservationsystem.ro;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class IndexRO {

    private Optional<String> source;
    private Optional<String> destination;
    private Optional<LocalDateTime> datetime;

}
