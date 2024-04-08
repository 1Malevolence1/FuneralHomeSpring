package com.example.FunneralHomeNew.Validator.employee;

import com.example.FunneralHomeNew.Validator.Validator;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidatorEmployee implements Validator<Employee> {
    @Override
    public Employee check(Employee employee) throws ExceptionValidator {
        try {
            if (validatorPassport(employee.getPassport()) != null && post(employee.getPost())
            && telephone(employee.getTelephone())) {
                return employee;
            } else {
                throw new ExceptionValidator("Ошибка в данных работника");
            }
        } catch (ExceptionValidator e) {
           log.info(e.getErrorMessage());
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
            log.info(e.getErrorMessage());
        }
        return false;
    }

    private Passport validatorPassport(Passport passport) throws ExceptionValidator {
        PassportValidator passportValidator = new PassportValidator();
        return passportValidator.check(passport);
    }
}
