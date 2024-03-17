package com.example.FunneralHomeNew.models.person;

import com.example.FunneralHomeNew.models.passport.Passport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employees")
    private Passport passport;

    @Column(name = "telephone")
    private String telephone;

    @Column(name =  "post")
    private String post;

}
