package com.example.FunneralHomeNew.repository;

import com.example.FunneralHomeNew.models.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface ContractRepository extends JpaRepository<Contract, Long>{
}
