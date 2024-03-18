package com.example.FunneralHomeNew.models.person.deadmean;


import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.person.Person;
import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Contract contract;

}
