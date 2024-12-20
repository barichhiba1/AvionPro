package org.sid.testprep.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AvionDto {
    String model;
    String color;
    String matricul;
    double price ;
}
