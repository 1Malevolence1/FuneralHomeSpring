package com.example.FunneralHomeNew.repository;

import com.example.FunneralHomeNew.models.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface ServicesRepository extends JpaRepository<Service,Long> {
}
