package com.example.FunneralHomeNew.models.person.employess;


import com.example.FunneralHomeNew.models.passport.Passport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "post")
    private String post;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
