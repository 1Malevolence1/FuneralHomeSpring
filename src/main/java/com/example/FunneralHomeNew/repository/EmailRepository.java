package com.example.FunneralHomeNew.repository;

import com.example.FunneralHomeNew.models.email.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
