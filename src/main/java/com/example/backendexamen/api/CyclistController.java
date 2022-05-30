package com.example.backendexamen.api;

import com.example.backendexamen.dto.CyclistRequest;
import com.example.backendexamen.dto.CyclistResponse;
import com.example.backendexamen.entities.Cyclist;
import com.example.backendexamen.repositories.CyclistRepository;
import com.example.backendexamen.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/cyclists")
public class CyclistController {
    CyclistService cyclistService;

    public CyclistController(CyclistService c) {this.cyclistService = c;}

    @GetMapping
    public List<CyclistResponse> getAllCyclists(@RequestParam(value = "team", required = false) String team) {
        return cyclistService.getAllCyclist(team);

    }

    @GetMapping("/{id}")
    CyclistResponse getCyclist(@PathVariable int id) throws Exception {
        return cyclistService.getCyclist(id);
    }

    @PostMapping
    public CyclistResponse addCyclist(@RequestBody CyclistRequest body){
        return cyclistService.addCyclist(body);
    }

    @DeleteMapping("/{id}")
    public void deleteCyclist(@PathVariable Long id){
        cyclistService.deleteCyclist(id);
    }

    @PutMapping
    public CyclistResponse editCyclist(@RequestBody CyclistRequest body) {
        return cyclistService.editCyclist(body);
    }

}
