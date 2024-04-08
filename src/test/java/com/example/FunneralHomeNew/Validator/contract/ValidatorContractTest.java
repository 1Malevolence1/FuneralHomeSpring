package com.example.FunneralHomeNew.Validator.contract;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.person.deadmean.DeadMean;
import com.example.FunneralHomeNew.models.person.сustomer.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorContractTest {


    @Test
    public void test() throws ExceptionValidator {

        Contract contract = new Contract();

        DeadMean deadMean = new DeadMean();
        deadMean.setName("Дмиртрий");
        deadMean.setSurname("Воронин");
        deadMean.setPatronymic("Иванович");

        Customer customer = new Customer();
        customer.setName("Тимурина");
        customer.setSurname("Арина");
        customer.setPatronymic("Генадиевнва");
        customer.setTelephone("79624061168");


        contract.setDeadMean(deadMean);
        contract.setCustomer(customer);

        ValidatorContract validatorContract = new ValidatorContract();
        assertNotNull(validatorContract.check(contract));

    }

}