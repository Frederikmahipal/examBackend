package com.example.backendexamen.repositories;
import com.example.backendexamen.entities.Cyclist;
import com.example.backendexamen.entities.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CyclistRepositoryTest {
    @Autowired
    CyclistRepository cyclistRepository;
    @Autowired
    TeamRepository teamRepository;
    @BeforeEach
    void setup() {
        teamRepository.saveAll( List.of(
                Team.builder()
                        .name("T1")
                        .build(),
                Team.builder()
                        .name("T2")
                        .build())
        );
        cyclistRepository.saveAll(
                List.of(
                        Cyclist.builder()
                                .name("Cyclist1")
                                .team(teamRepository.getTeamByName("T1"))
                                .age(10)
                                .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(25).plusSeconds(30))
                                .sprintPoints(2)
                                .mountainPoints(3)
                                .build(),
                        Cyclist.builder()
                                .name("Cyclist2")
                                .team(teamRepository.getTeamByName("T2"))
                                .age(29)
                                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(05).plusSeconds(13))
                                .sprintPoints(22)
                                .mountainPoints(13)
                                .build(),
                        Cyclist.builder()
                                .name("Cyclist3")
                                .team(teamRepository.getTeamByName("T1"))
                                .age(20)
                                .timeTotal(Duration.ZERO.plusHours(3).plusMinutes(10).plusSeconds(21))
                                .sprintPoints(215)
                                .mountainPoints(33)
                                .build(),
                        Cyclist.builder()
                                .name("Cyclist4")
                                .team(teamRepository.getTeamByName("T2"))
                                .age(25)
                                .timeTotal(Duration.ZERO.plusHours(1).plusMinutes(43).plusSeconds(55))
                                .sprintPoints(73)
                                .mountainPoints(33)
                                .build(),
                        Cyclist.builder()
                                .name("Cyclist5")
                                .team(teamRepository.getTeamByName("T2"))
                                .age(11)
                                .timeTotal(Duration.ZERO.plusHours(4).plusMinutes(32).plusSeconds(23))
                                .sprintPoints(20)
                                .mountainPoints(33)
                                .build())
        );
    }


    @Test
    void addCyclist() {
        List<Cyclist> T1 = cyclistRepository.getAllByTeam_Name("T1");
        assertEquals(T1.size(),2);

        List<Cyclist> T2 = cyclistRepository.getAllByTeam_Name("T2");
        assertEquals(T2.size(),3);
    }
}
