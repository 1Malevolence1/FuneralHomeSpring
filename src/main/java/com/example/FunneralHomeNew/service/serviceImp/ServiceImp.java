package com.example.FunneralHomeNew.service.serviceImp;

import com.example.FunneralHomeNew.models.service.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

public interface ServiceImp {

    Service createService(String title, Integer price);

    @Cacheable
    List<Service> getList();

    void deleted(Long id);

    Optional<Service> getService(Long id);

    void updateService(Long id, String titile, Integer price);
}
