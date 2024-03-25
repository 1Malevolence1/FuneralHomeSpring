package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import com.example.FunneralHomeNew.repository.EmployeeRepository;
import com.example.FunneralHomeNew.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PassportRepository passportRepository;


    public void addEmployee(Employee employee, Passport passport){
        log.info("save product {}", employee);
        Employee serviceFromDb = employeeRepository.save(employee);
        Passport passportFormDb= passportRepository.save(passport);

    }


    public List<Employee> getEmployeeList( ) {
        return employeeRepository.findAll();
    }

    public void deletedEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).orElse(null);
    }



}
