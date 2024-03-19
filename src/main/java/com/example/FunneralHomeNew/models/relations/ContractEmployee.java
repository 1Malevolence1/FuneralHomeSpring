package com.example.FunneralHomeNew.models.relations;

import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contract_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractEmployee  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Contract contract;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Employee employee;
}




