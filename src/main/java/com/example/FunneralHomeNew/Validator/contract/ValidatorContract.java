package com.example.FunneralHomeNew.Validator.contract;

import com.example.FunneralHomeNew.Validator.Validator;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidatorContract implements Validator<Contract> {
    @Override
    public Contract check(Contract contract) throws ExceptionValidator {
        try {

            if (validatorDeadMean(contract.getDeadMean()) && validatorCustomer(contract.getCustomer())) return contract;
            else throw new ExceptionValidator("Ошибка данных конракта");
        } catch (ExceptionValidator e) {
            log.info(e.getErrorMessage());
        }
        return null;
    }

    private boolean validatorCustomer(Customer customer) throws ExceptionValidator {
        ValidatorCustomer validator = new ValidatorCustomer();
        return validator.check(customer) != null;
    }

    private boolean validatorDeadMean(DeadMean deadMean) throws ExceptionValidator {
        ValidatorDeadMean validator = new ValidatorDeadMean();
        return validator.check(deadMean) != null;
    }


}
