package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.Validator.employee.ValidatorEmployee;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
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
    public void add(Employee employee) throws ExceptionValidator {
            employeeRepository.save(employee);
            log.info("добавили сотрудника {}", employee);
        }


    @Override
    public List<Employee> getList() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleted(Long id) {
           employeeRepository.deleteById(id);
           log.info("Удалили сотрудника из базы данных с id: {}", id);
    }

    @Override
    public Employee getObject(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


}

