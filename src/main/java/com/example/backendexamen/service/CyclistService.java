package com.example.backendexamen.service;

import com.example.backendexamen.dto.CyclistRequest;
import com.example.backendexamen.dto.CyclistResponse;
import com.example.backendexamen.entities.Cyclist;
import com.example.backendexamen.error.Client4xxException;
import com.example.backendexamen.repositories.CyclistRepository;
import com.example.backendexamen.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CyclistService {
    CyclistRepository cyclistRepository;
    TeamRepository teamRepository;

    public CyclistService(CyclistRepository cyclistRepository, TeamRepository teamRepository) {
        this.cyclistRepository = cyclistRepository;
        this.teamRepository = teamRepository;
    }

    public List<CyclistResponse> getAllCyclist(String teamName) {
        List<Cyclist> cyclists;

        if (teamName != null) {
            cyclists = cyclistRepository.getAllByTeam_Name(teamName);
        } else {
            cyclists = cyclistRepository.findAll();
        }

        return cyclists.stream().map((cyclist) -> new CyclistResponse(cyclist)).collect(Collectors.toList());
    }

    public CyclistResponse getCyclist(long id) throws Exception {
        Cyclist c = cyclistRepository.findById(id).orElseThrow(() -> new Client4xxException("No cyclist with this id exists"));
        return new CyclistResponse(c);
    }


    public CyclistResponse addCyclist(CyclistRequest body) {
        Cyclist cyclistToAdd = Cyclist.builder()
                .name(body.getName())
                .team(teamRepository.getTeamByName(body.getTeam()))
                .age(body.getAge())
                .timeTotal(Duration.ZERO.plusSeconds(body.getTimeTotal()))
                .mountainPoints(body.getMountainPoints())
                .sprintPoints(body.getSprintPoints())
                .build();

        Cyclist cyclist = cyclistRepository.save(cyclistToAdd);

        return new CyclistResponse(cyclist);
    }

    public void deleteCyclist(Long id) {
        cyclistRepository.deleteById(id);
    }

    public CyclistResponse editCyclist(CyclistRequest body) {
        // FIXME: 30/05/2022
        return null;
    }

}