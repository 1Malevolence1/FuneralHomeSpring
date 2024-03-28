package com.example.FunneralHomeNew.Validator.contract;

import com.example.FunneralHomeNew.Validator.Validator;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import lombok.NonNull;

import java.util.Random;

public class ValidatorContract implements Validator<Contract> {
    @Override
    public Contract check(Contract contract) throws ExceptionValidator {
        validatorDeadMean(contract.getDeadMean());
        // проверка данных метрвеца
        // проверка данных закачика
        return contract;
    }

    private boolean validatorDeadMean(DeadMean deadMean) throws ExceptionValidator {
        ValidatorDeadMean validator = new ValidatorDeadMean();
        return validator.check(deadMean) != null;
    }


}
