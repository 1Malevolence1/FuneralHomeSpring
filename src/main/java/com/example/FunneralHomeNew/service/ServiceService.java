package com.example.FunneralHomeNew.service;


import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class ServiceService implements DataManagementInterface<Service>, SplitArray {


    private final ServicesRepository serviceRepository;


    @Override
    public void add(Service service) {
        log.info("save product {}", service);
        serviceRepository.save(service);

    }

    @Override
    public List<Service> getList() {
        return serviceRepository.findAll();
    }

    @Override
    public void deleted(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Service getObject(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Long> splitArray(String massive) {

        String[] array = massive.split(",");

        List<Long> listId = new ArrayList<>();

        for (String item : array
        ) {
            listId.add(Long.parseLong(item));
        }

        return listId;
    }
}
