package com.example.FunneralHomeNew.models.service;



import com.example.FunneralHomeNew.models.relations.ContractService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "services")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "service")
    private List<ContractService> contractServices;

}
