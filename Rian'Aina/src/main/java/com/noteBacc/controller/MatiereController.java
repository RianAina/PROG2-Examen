package com.noteBacc.controller;

import com.noteBacc.model.Matiere;
import com.noteBacc.service.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MatiereController {
    private MatiereService matiereService;

    @GetMapping("/matiere")
    public List<Matiere> getAllMatiere() {
        return this.matiereService.getAllMatiere();
    }

    @GetMapping("/matiere/{id}")
    public Matiere getMatiereById(@PathVariable int id) {
        return this.matiereService.getMatiereById(id);
    }

    @PostMapping("/matiere")
    public Matiere createMatiere(@RequestBody Matiere matiere) {
        return matiereService.createMatiere(matiere);
    }

    @PutMapping("/matiere/{id}")
    public Matiere updateMatiere(@PathVariable int id, @RequestBody Matiere matiere) {
        return matiereService.updateMatiere(id, matiere);
    }

    @DeleteMapping("/matiere/{id}")
    public String deleteMatiere(@PathVariable int id){
        return matiereService.deleteMatiere(id);
    }
}
