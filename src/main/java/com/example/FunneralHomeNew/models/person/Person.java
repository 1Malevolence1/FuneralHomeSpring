package com.example.FunneralHomeNew.models.person;


import com.example.FunneralHomeNew.models.passport.Passport;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass // Аннотация @MappedSuperclass позволяет вынести общие поля в родительский класс, но при этом не создавать для него отдельную таблицу
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

}
