package com.example.FunneralHomeNew.repository;

import com.example.FunneralHomeNew.models.person.employess.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
