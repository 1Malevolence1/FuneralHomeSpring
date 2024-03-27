package com.example.FunneralHomeNew.Validator;

import com.example.FunneralHomeNew.exception.ExceptionValidator;

public interface Validator<T> {
    T check(T object) throws ExceptionValidator;
}
