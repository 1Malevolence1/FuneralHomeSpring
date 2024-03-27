package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.email.Email;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import com.example.FunneralHomeNew.repository.ContractRepository;

import com.example.FunneralHomeNew.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractService {

   private final ContractRepository contractRepository;

   private final EmailRepository emailRepository;


   public void addContract(Contract contract, Email email, Customer customer){

      Email emailFromBd = emailRepository.save(email);
      Contract contractFromBd = contractRepository.save(contract);
   }

}
