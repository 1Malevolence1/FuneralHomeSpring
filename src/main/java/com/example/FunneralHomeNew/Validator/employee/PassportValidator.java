package com.example.FunneralHomeNew.Validator.employee;

import com.example.FunneralHomeNew.Validator.Validator;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.passport.Passport;

import java.time.LocalDate;


public class PassportValidator implements Validator<Passport> {
    @Override
    public Passport check(Passport passport) throws ExceptionValidator {

        if (checkFIO((passport)) && series(passport.getSeries())
                && number(passport.getNumber())
                && placeOfIssue(passport.getPlaceOfIssue())) return passport;

        return null;
    }

  /*  private boolean dateOfIssue(LocalDate localDate) throws ExceptionValidator {
        if(localDate != null) return true;
        else throw new ExceptionValidator("Ошибка: Место выдачи паспорта");
    }*/

    private boolean placeOfIssue(String placeOfIssue) throws ExceptionValidator {
        return validator(placeOfIssue, "место выдачи паспорта");
    }

    private boolean series(String series) throws ExceptionValidator {
        return validator(series, 4, "серия паспорта");
    }

    private boolean number(String number) throws ExceptionValidator {
        return validator(number, 6, "номер паспорта");
    }

    private boolean checkFIO(Passport passport) throws ExceptionValidator {
        FIOValidator fioValidator = new FIOValidator();
        return fioValidator.checkFIO(passport.getName(), passport.getSurname(), passport.getPatronymic());
    }

    private boolean validator(String value, int length, String errorMassage) throws ExceptionValidator {
        if (value.length() == length) return true;
        else throw new ExceptionValidator("Ошибка в: " + errorMassage);

    }

    private boolean validator(String value, String errorMassage) throws ExceptionValidator {
            if (!value.isEmpty()) return true;
            else  throw new ExceptionValidator("Ошибка в: " + errorMassage);


    }
}
