package com.example.FunneralHomeNew.testResurs;

import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.email.Email;
import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import com.example.FunneralHomeNew.models.relations.ContractEmployee;
import com.example.FunneralHomeNew.models.relations.ContractService;
import com.example.FunneralHomeNew.models.service.Service;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
public class TestData {

    public static void main(String[] args) {

    }

  public static Service buildTestServiceOne(){
      Service service = new Service();
      service.setTitle("Вырыть яму");
      service.setPrice(15000);
      return service;
    }


    public static Service buildTestServiceTwo(){
        Service service = new Service();
        service.setTitle("Заказать гроб");
        service.setPrice(10000);
        return service;
    }

    public static Employee buildTestEmployee(){
      Employee employee = new Employee();
      employee.setTelephone("89624061168");
      employee.setPost("Директор");
      employee.setPassport(buildTestPassport());
      return employee;
    }

    public static Passport buildTestPassport(){
        Passport passport = new Passport();
        passport.setName("Даниил");
        passport.setSurname("Владимиров");
        passport.setPatronymic("Владимирович");
        passport.setSeries("0044");
        passport.setNumber("123456");
        return passport;
    }


    public static DeadMean buildTestDeadMen(){
      DeadMean deadMean = new DeadMean();
      deadMean.setName("Дмиртрий");
      deadMean.setSurname("Воронин");
      deadMean.setPatronymic("Иванович");

      return deadMean;
    }


    public static Customer buildTestCustomer(){
      Customer customer = new Customer();
      customer.setName("Тимурина");
      customer.setSurname("Арина");
      customer.setPatronymic("Генадиевнва");
      customer.setTelephone("896233412");
      customer.setEmail(buildTestEmail());

      return customer;
    }


    public static Email buildTestEmail(){
      Email email = new Email();
      email.setUsername("danil36rusdanil");
      email.setDomain("@mail");
      email.setExtension(".ru");

      return email;
    }


    public Contract buildTestContract(){
        Contract contract = new Contract();
        contract.setCustomer(buildTestCustomer());
        contract.setDeadMean(buildTestDeadMen());
        contract.setContractEmployee(buildTestContractEmployee(contract));
        contract.setContractService(buildTestContractService(contract));


        return contract;
    }

    public static List<ContractService> buildTestContractService(Contract contract){
        List<ContractService>  listContractService = new ArrayList<>();

        ContractService contractServiceOne = new ContractService();

        contractServiceOne.setContract(contract);
        contractServiceOne.setService(buildTestServiceOne());

        listContractService.add(contractServiceOne);


        ContractService contractServiceTwo = new ContractService();

        contractServiceOne.setContract(contract);
        contractServiceOne.setService(buildTestServiceTwo());

        listContractService.add(contractServiceTwo);

        return listContractService;
    }

    public static List<ContractEmployee> buildTestContractEmployee(Contract contract){
        List<ContractEmployee>  listContractEmploy = new ArrayList<>();

        ContractEmployee contractEmployee =  new ContractEmployee();
        contractEmployee.setContract(contract);
        contractEmployee.setEmployee(buildTestEmployee());

        listContractEmploy.add(contractEmployee);

        return listContractEmploy;
    }

    }