package com.example.backendexamen.dto;

import com.example.backendexamen.entities.Cyclist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CyclistResponse {

    private long id;
    private String name;
    private int age;
    private String team;
    private String timeTotal;
    private int sprintPoints;
    private int mountainPoints;

    public CyclistResponse(Cyclist cyclist) {
        this.id = cyclist.getId();
        this.name = cyclist.getName();
        this.age = cyclist.getAge();
        this.team = cyclist.getTeam().getName();


    }

}
