package com.example.FunneralHomeNew.models.person;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name= "deadMean")
@Data
@AllArgsConstructor
public class DeadMean extends Person {

    @Column(name = "dateOfBirthday")
    private LocalDate dateOfBirthday;

    @Column(name = "dateOfDead")
    private LocalDate dateOfDead;
}
