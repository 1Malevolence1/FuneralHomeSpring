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
public class ServiceEmployee implements DataManagementInterface<Employee> {

    private final EmployeeRepository employeeRepository;


    public void loader(Employee employee, Passport passport){
        log.info("добавили сотрудника {}, {}", passport, employee);
        employee.setPassport(passport);
        employeeRepository.save(employee);
    }

    @Override
    public void add(Employee employee) {
        log.info("добавили сотрудника {}", employee);
        employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getList() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleted(Long id) {
           employeeRepository.deleteById(id);
    }

    @Override
    public Employee getObject(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


}

