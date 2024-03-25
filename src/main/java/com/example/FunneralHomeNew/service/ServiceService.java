package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.repository.ServiceRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public void addService(Service service){
        log.info("save product {}", service);
        Service serviceFromDb = serviceRepository.save(service);

    }
    @Cacheable("services")
    public List<Service> getServicesList( ) {
          return serviceRepository.findAll();
    }

    public void deletedService(Long id){
        serviceRepository.deleteById(id);
    }

    public Service getService(Long id){
        return serviceRepository.findById(id).orElse(null);
    }
}
