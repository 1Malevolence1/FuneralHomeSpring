package com.example.FunneralHomeNew.models.contract;

import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
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
    private List<Employee> employeesList = new ArrayList<>();

    @OneToMany(cascade= CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "contract")
    private List<Service> servicesList = new ArrayList<>();



    @PrePersist
    public void init(){
        dateConclusionContract = LocalDate.now();
    }

    public void addEmployees(Employee employees) {
        employeesList = crateList(employeesList, employees);
    }

    public void addService(Service services){
       servicesList = crateList(servicesList, services);
    }


    private <T> List<T> crateList(List<T> list, T object) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(object);
        return list;
    }
}
