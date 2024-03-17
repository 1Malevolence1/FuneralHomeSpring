package com.example.FunneralHomeNew.models.Person;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;



@NoArgsConstructor
@Data
@MappedSuperclass // Аннотация @MappedSuperclass позволяет вынести общие поля в родительский класс, но при этом не создавать для него отдельную таблицу

public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tale")
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

}
