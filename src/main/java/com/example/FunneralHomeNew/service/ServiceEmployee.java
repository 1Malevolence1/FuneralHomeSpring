package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import com.example.FunneralHomeNew.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;

import java.util.List;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceEmployee implements DataManagementInterface<Employee> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ServiceEmployee.class);
    private final EmployeeRepository employeeRepository;


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

