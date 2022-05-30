package com.example.backendexamen.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CyclistRequest {
    private long id;
    private String name;
    private String team;
    private int age;
    private int timeTotal;
    private int sprintPoints;
    private int mountainPoints;
}
