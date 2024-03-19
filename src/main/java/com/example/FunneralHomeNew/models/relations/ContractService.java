package com.example.FunneralHomeNew.models.relations;

import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.service.Service;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contract_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractService   {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Contract contract;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Service service;
}
