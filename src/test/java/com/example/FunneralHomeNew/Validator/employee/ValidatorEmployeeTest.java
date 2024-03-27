package com.example.FunneralHomeNew.Validator.employee;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorEmployeeTest {
    @Test void test() throws ExceptionValidator {
        Passport passport = new Passport();
        passport.setName("Даниил");
        passport.setSurname("Владимиров");
        passport.setPatronymic("Владимирович");
        passport.setSeries("1234");
        passport.setNumber("123456");
        passport.setPlaceOfIssue("dfd");
        Employee employee = new Employee(1L,"+79624224", "Директор", passport);
        ValidatorEmployee validatorEmployee = new ValidatorEmployee();
        assertNotNull(validatorEmployee.check(employee));


    }

}