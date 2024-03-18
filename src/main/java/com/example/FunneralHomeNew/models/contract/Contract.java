package com.example.FunneralHomeNew.models.contract;

import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.employess.Employees;
import com.example.FunneralHomeNew.models.service.Services;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contract")
@Data
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "contract")
    private Customer customer;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "contract")
    private DeadMean deadMean;

    @Column(name = "dateConclusionContract")
    @Temporal(TemporalType.DATE)
    private LocalDate dateConclusionContract;

    @Column(name = "totalAmountForServices")
    private Double totalAmountForServices;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "contract")
    private List<Employees> employeesList;

    @OneToMany(cascade= CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "contract")
    private List<Services> servicesList;



    @PrePersist
    public void init(){
        dateConclusionContract = LocalDate.now();
    }

}
