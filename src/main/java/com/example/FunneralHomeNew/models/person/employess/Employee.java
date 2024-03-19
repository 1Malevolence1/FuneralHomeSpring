package com.example.FunneralHomeNew.models.person.employess;


import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.relations.ContractEmployee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "telephone")
    private String telephone;

    @Column(name =  "post")
    private String post;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employees")
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employee")
    private List<ContractEmployee> contractEmployee;

}
