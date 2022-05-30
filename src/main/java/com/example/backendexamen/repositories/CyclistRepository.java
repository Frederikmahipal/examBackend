package com.example.backendexamen.repositories;

import com.example.backendexamen.entities.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist,Long> {
    List<Cyclist> getAllByTeam_Name(String name);
}