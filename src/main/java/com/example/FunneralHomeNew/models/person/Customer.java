package com.example.FunneralHomeNew.models.person;

import com.example.FunneralHomeNew.models.Email.Email;
import com.example.FunneralHomeNew.models.passport.Passport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
public class Customer extends Person{


    @Column(name = "telephone")
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER, mappedBy = "customer")
    private Email email;
}
