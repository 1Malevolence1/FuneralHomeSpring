package com.example.FunneralHomeNew.service.serviceImp;


import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.repository.ServicesRepository;
import com.example.FunneralHomeNew.service.SplitArray;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class ServiceService implements ServiceImp, SplitArray {


    private final ServicesRepository serviceRepository;


    @Override

    public Service createService(String title, Integer price) {
        log.info("Создание новой усулги. Названи:{}, цена: {}", title, price);
        return serviceRepository.save(new Service(null , title, price));
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
    public Optional<Service> getService(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void updateService(Long id, String newTitile, Integer newPrice) {
            Service service = getService(id).orElseThrow();
            service.setTitle(newTitile);
            service.setPrice(newPrice);
            serviceRepository.save(service);
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
