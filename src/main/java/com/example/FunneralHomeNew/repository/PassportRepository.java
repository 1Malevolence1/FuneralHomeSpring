package com.example.FunneralHomeNew.repository;

import com.example.FunneralHomeNew.models.passport.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
     Passport findByNumber(String number);
}
