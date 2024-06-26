package com.example.FunneralHomeNew.models.passport;



import com.example.FunneralHomeNew.models.person.employess.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "passport")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
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

    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;

    @Column(name = "placeOfIssue")
    private String placeOfIssue;

    @Column(name = "dateOfIssue")
    private LocalDate dateOfIssue;

   @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Employee employees;

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", series='" + series + '\'' +
                ", number='" + number + '\'' +
                ", placeOfIssue='" + placeOfIssue + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                '}';
    }

}
