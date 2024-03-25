package com.example.FunneralHomeNew.service;

import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface DataManagementInterface<T> {
    void add(T t);
    @Cacheable
    List<T> getList();

    void deleted(Long id);

    T getObject(Long id);


}
