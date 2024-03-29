package com.example.FunneralHomeNew.Validator.employee;

import com.example.FunneralHomeNew.Validator.Validator;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.person.employess.Employee;

public class ValidatorEmployee implements Validator<Employee> {
    @Override
    public Employee check(Employee employee) throws ExceptionValidator {
        try {
            PassportValidator passportValidator = new PassportValidator();

            if (passportValidator.check(employee.getPassport()) != null && post(employee.getPost())
            && telephone(employee.getTelephone())) {
                return employee;
            } else {
                throw new ExceptionValidator("Ошибка в данных работника");
            }
        } catch (ExceptionValidator e) {
            System.out.println(e.getErrorMessage());
        }
        return null;
    }

    private boolean post(String post){
        return validate(post, "Должность");
    }


    private boolean telephone(String telephone){
        return validate(telephone, "Телефон");
    }

    private boolean validate(String value, String errorMessage){
        try {
            if(!value.isEmpty()) return true;

            else throw new ExceptionValidator("Ошибка в данных:" + errorMessage );

        } catch (ExceptionValidator e){
            System.out.println(e.getErrorMessage());
        }
        return false;
    }
}
