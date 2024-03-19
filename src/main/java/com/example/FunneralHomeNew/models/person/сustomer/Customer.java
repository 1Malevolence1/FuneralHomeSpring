package com.example.FunneralHomeNew.models.person.сustomer;

import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.email.Email;
import com.example.FunneralHomeNew.models.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person {

    @Column(name = "telephone")
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER, mappedBy = "customer")
    private Email email;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Contract contract;
}
