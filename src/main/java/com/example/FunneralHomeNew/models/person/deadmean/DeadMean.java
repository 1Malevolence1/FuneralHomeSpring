package com.example.FunneralHomeNew.models.person.deadmean;


import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name= "deadMean")
@Data
@NoArgsConstructor
public class DeadMean extends Person {

    @Column(name = "dateOfBirthday")
    private LocalDate dateOfBirthday;

    @Column(name = "dateOfDead")
    private LocalDate dateOfDead;

    @OneToOne(mappedBy = "deadMean", cascade = CascadeType.ALL)
    private Contract contract;

}
