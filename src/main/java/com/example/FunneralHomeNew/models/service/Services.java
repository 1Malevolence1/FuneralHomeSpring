package com.example.FunneralHomeNew.models.service;


import com.example.FunneralHomeNew.models.contract.Contract;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "services")
@Data
@AllArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "prise")
    private Integer prise;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Contract contract;
}
