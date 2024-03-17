package com.example.FunneralHomeNew.models.сustomer;

import com.example.FunneralHomeNew.models.Email.Email;
import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
public class Customer extends Person {


    @Column(name = "telephone")
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER, mappedBy = "customer")
    private Email email;
}
