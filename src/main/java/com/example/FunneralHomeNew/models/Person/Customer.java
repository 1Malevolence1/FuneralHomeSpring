package com.example.FunneralHomeNew.models.Person;

import com.example.FunneralHomeNew.models.Email.Email;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer")
@Data
@AllArgsConstructor
public class Customer extends Person{

    @Column(name = "telephone")
    private String telephone;


    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER, mappedBy = "customer")
    private Email email;
}
