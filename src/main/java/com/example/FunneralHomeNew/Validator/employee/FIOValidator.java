package com.example.FunneralHomeNew.Validator.employee;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.person.Person;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public class FIOValidator {


    public boolean checkName(String name) throws ExceptionValidator {
       return validate(name, "имени");
    }


    public boolean checkSurname(String surname) throws ExceptionValidator {
        return validate(surname, "фамалии");
    }


    public boolean checkPatronymic(String patronymic) throws ExceptionValidator {
       return validate(patronymic, " отчестве");
    }

    private boolean validate(String values, String errorMessage) throws ExceptionValidator {
        if (!values.matches(".*\\d.*")  && !values.isEmpty() ) return true;
        else throw new ExceptionValidator("Ошибка в " + errorMessage);
    }
}
