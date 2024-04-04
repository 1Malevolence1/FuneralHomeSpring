package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.email.Email;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import com.example.FunneralHomeNew.repository.ContractRepository;

import com.example.FunneralHomeNew.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractService implements DataManagementInterface<Contract> {

   private final ContractRepository contractRepository;


   @Override
   public void add(Contract contract) throws ExceptionValidator {
         log.info("Созда конракт: {}", contract);
         contractRepository.save(contract);
   }

   @Override
   public List<Contract> getList() {
      return contractRepository.findAll();
   }

   @Override
   public void deleted(Long id) {
         contractRepository.deleteById(id);
   }

   @Override
   public Contract getObject(Long id) {
      return contractRepository.findById(id).orElse(null);
   }
}
