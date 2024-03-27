package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface DataManagementInterface<T> {
    void add(T t) throws ExceptionValidator;
    @Cacheable
    List<T> getList();

    void deleted(Long id);

    T getObject(Long id);


}
