package com.example.FunneralHomeNew.Validator.contract;

import com.example.FunneralHomeNew.Validator.Validator;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;

public class ValidatorContract implements Validator<Contract> {
    @Override
    public Contract check(Contract contract) throws ExceptionValidator {
        validatorDeadMean(contract.getDeadMean());
        validatorCustomer(contract.getCustomer());
        // проверка данных закачика
        return contract;
    }

    private void validatorCustomer(Customer customer) {
        ValidatorCustomer validator = new ValidatorCustomer();
    }

    private boolean validatorDeadMean(DeadMean deadMean) throws ExceptionValidator {
        ValidatorDeadMean validator = new ValidatorDeadMean();
        return validator.check(deadMean) != null;
    }


}
