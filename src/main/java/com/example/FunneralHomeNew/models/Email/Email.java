package com.example.FunneralHomeNew.models.Email;

import com.example.FunneralHomeNew.models.person.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "email")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username; // "kava1434"

    @Column(name = "domain")
    private String domain; // "@mail"

    @Column(name = "extension")
    private String extension; // ".ru"

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Customer customer;
}
