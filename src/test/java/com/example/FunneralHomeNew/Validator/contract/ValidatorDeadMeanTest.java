package com.example.FunneralHomeNew.Validator.contract;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorDeadMeanTest {

    @Test
    public void test() throws ExceptionValidator {
        DeadMean deadMean = new DeadMean(1L,"Горин","Генадий", "Сергеевич243");
        ValidatorDeadMean validatorDeadMean  = new ValidatorDeadMean();
        assertNotNull(validatorDeadMean.check(deadMean));
    }
}