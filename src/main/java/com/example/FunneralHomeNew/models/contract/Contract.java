package com.example.FunneralHomeNew.models.contract;

import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import com.example.FunneralHomeNew.models.relations.Employs;
import com.example.FunneralHomeNew.models.service.Service;
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
    @Column(name = "contract_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deadMean_id")
    private DeadMean deadMean;

    @Column(name = "dateConclusionContract")
    @Temporal(TemporalType.DATE)
    private LocalDate dateConclusionContract;

    @Column(name = "totalAmountForServices")
    private Double totalAmountForServices;

    @ManyToMany
    @JoinTable(name = "contract_employee",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> listEmployee;

    @ManyToMany
    @JoinTable(name = "contract_services",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> listService;





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
