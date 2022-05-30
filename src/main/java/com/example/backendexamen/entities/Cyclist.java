package com.example.backendexamen.entities;



import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cyclist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private Duration timeTotal;
    private int sprintPoints;
    private int mountainPoints;

    @ManyToOne()
    private Team team;


    public Cyclist(String name) {
        this.name = name;
    }
}