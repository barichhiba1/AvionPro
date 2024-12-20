package org.sid.testprep.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Avion {
    @Id @GeneratedValue
    Long id_Avion;
    String model;
    String  color;
    String matricul;
    double price ;

}
