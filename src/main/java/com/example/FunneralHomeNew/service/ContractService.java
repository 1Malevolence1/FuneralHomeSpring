package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class ContractService implements DataManagementInterface<Contract> {

   private final ContractRepository contractRepository;

   private final ServiceService serviceService;

   private final ServiceEmployee serviceEmployee;


   @Override
   public void add(Contract contract) throws ExceptionValidator {
         contract.setTotalAmountForServices(totalAmountForServices(contract.getListService()));
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


   public double totalAmountForServices(List<Service> services){
      double sum = 0;
      for (Service item : services
              ) {
         sum += item.getPrice();
      }
      return sum;
   }


   public void addServiceToTheContract(Contract contract, String massive){
      for (Long item: serviceService.splitArray(massive)
           ) {
         contract.addService(serviceService.getObject(item));
      }
   }

   public void addSEmployeeToTheContract(Contract contract, String massive){
      for (Long item: serviceEmployee.splitArray(massive)
      ) {
         contract.addEmploys(serviceEmployee.getObject(item));
      }
   }
   }

