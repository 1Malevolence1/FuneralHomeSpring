package com.example.FunneralHomeNew.Validator.contract;

import com.example.FunneralHomeNew.Validator.Validator;
import com.example.FunneralHomeNew.Validator.employee.FIOValidator;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
public class ValidatorCustomer implements Validator<Customer> {


    @Override
    public Customer check(Customer customer) throws ExceptionValidator {
        try {

            if(checkFIO(customer) && checkTelephone(customer.getTelephone())) {
                return customer;
            } else throw new ExceptionValidator("Ошибка в данных клиента");

        } catch (ExceptionValidator e){
          log.info(e.getErrorMessage());
        }

        return null;
    }


    private boolean checkFIO(Customer customer) throws ExceptionValidator {
        FIOValidator fioValidator = new FIOValidator();
        if (fioValidator.checkFIO(customer.getName(), customer.getSurname(), customer.getPatronymic())) return true;
        else throw new ExceptionValidator("Ошибка в ФИО клиента");
    }

    private boolean checkTelephone(String telephoned) throws ExceptionValidator {
    /*    Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        Matcher matcher = pattern.matcher(telephoned);
        if(matcher.matches()) return true;
        else throw new ExceptionValidator("Ошибка в данных телефона");*/
        return true;
    }

/*
    private boolean checkEmail(){

    }*/
}
