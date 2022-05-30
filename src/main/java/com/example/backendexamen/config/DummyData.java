package com.example.backendexamen.config;

import com.example.backendexamen.entities.Cyclist;
import com.example.backendexamen.entities.Team;
import com.example.backendexamen.repositories.CyclistRepository;
import com.example.backendexamen.repositories.TeamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class DummyData implements ApplicationRunner {
    private CyclistRepository cyclistRepository;
    private TeamRepository teamRepository;

    public DummyData(CyclistRepository cyclistRepository, TeamRepository teamRepository) {
        this.cyclistRepository = cyclistRepository;
        this.teamRepository = teamRepository;
    }

    public List<Team> makeTeams() {
        return List.of(
                Team.builder()
                        .name("Movistar")
                        .build(),
                Team.builder()
                        .name("Astana")
                        .build(),
                Team.builder()
                        .name("Redbull4Life")
                        .build());
    }

    public List<Cyclist> makeCyclists() {


        return List.of(
                Cyclist.builder()
                        .name("Rytter1")
                        .team(teamRepository.getReferenceById(1))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter2")
                        .team(teamRepository.getReferenceById(2))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter3")
                        .team(teamRepository.getReferenceById(2))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter4")
                        .team(teamRepository.getReferenceById(3))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter5")
                        .team(teamRepository.getReferenceById(1))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter6")
                        .team(teamRepository.getReferenceById(3))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter7")
                        .team(teamRepository.getReferenceById(2))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter8")
                        .team(teamRepository.getReferenceById(3))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter9")
                        .team(teamRepository.getReferenceById(1))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter10")
                        .team(teamRepository.getReferenceById(2))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter11")
                        .team(teamRepository.getReferenceById(3))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build(),
                Cyclist.builder()
                        .name("Rytter12")
                        .team(teamRepository.getReferenceById(2))
                        .age(15)
                        .timeTotal(Duration.ZERO.plusHours(5).plusMinutes(11).plusSeconds(26))
                        .sprintPoints(24)
                        .mountainPoints(37)
                        .build()


        );
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        teamRepository.deleteAll();
        teamRepository.saveAll(makeTeams());

        cyclistRepository.deleteAll();
        cyclistRepository.saveAll(makeCyclists());
    }
}