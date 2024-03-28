package com.example.FunneralHomeNew.Validator.contract;

import com.example.FunneralHomeNew.Validator.Validator;
import com.example.FunneralHomeNew.Validator.employee.FIOValidator;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;

public class ValidatorDeadMean implements Validator<DeadMean> {
    @Override
    public DeadMean check(DeadMean deadMean) throws ExceptionValidator {

        try {
            if (checkFIO(deadMean)) return deadMean;
            else throw new ExceptionValidator("Ошибка в данных покойника");
        }
        catch (ExceptionValidator e) {
            System.out.println(e.getErrorMessage());
        }
        return null;
    }


    private boolean checkFIO(DeadMean deadMean) throws ExceptionValidator {
        FIOValidator fioValidator = new FIOValidator();
        if (fioValidator.checkFIO(deadMean.getName(), deadMean.getSurname(), deadMean.getPatronymic())) return true;
        else throw new ExceptionValidator("Ошибка в ФИО покойника");
    }
}

