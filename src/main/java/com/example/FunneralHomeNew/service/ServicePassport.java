package com.example.FunneralHomeNew.service;

import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicePassport {
    private final PassportRepository passportRepository;

    public void loader(Passport passport){
        passportRepository.save(passport);
    }

    public Passport getPassport(Long id){
        if (id == null) {
            return null;
        }
        return passportRepository.findById(id).orElse(null);
    }
}
