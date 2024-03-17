package com.example.FunneralHomeNew.models.Person;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name= "DeadMean")
@Data
@AllArgsConstructor
public class DeadMean extends Person {

    @Column(name = "dateOfBirthday")
    private LocalDate dateOfBirthday;

    @Column(name = "dateOfDead")
    private LocalDate dateOfDead;
}
