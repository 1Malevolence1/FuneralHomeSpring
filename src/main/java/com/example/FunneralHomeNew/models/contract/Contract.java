package com.example.FunneralHomeNew.models.contract;

import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import com.example.FunneralHomeNew.models.relations.ContractEmployee;
import com.example.FunneralHomeNew.models.relations.ContractService;
import com.example.FunneralHomeNew.models.relations.Employs;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "contract")
@Data
@AllArgsConstructor
@NoArgsConstructor // созадёт пустой конструктор
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "contract")
    private Customer customer;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "contract")
    private DeadMean deadMean;

    @Column(name = "dateConclusionContract")
    @Temporal(TemporalType.DATE)
    private LocalDate dateConclusionContract;

    @Column(name = "totalAmountForServices")
    private Double totalAmountForServices;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "contract")
    private List<ContractEmployee> contractEmployee;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "contract")
    private List<ContractService> contractService;
    @PostLoad // доабвит дату после загрузки всего объекта
    public void init(){
        dateConclusionContract = LocalDate.now();
    }


    public void addEmploys(List<Employs> list, Employs employs){
        crateList(list, employs);
    }

    private <T> void crateList(List<T> list, T object) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(object);
    }
}
