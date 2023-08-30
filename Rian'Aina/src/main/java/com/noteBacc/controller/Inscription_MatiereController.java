package com.noteBacc.controller;

import com.noteBacc.model.Inscription_Matiere;
import com.noteBacc.service.Inscription_MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class Inscription_MatiereController {
    private Inscription_MatiereService inscriptionMatiereService;

    @GetMapping("/inscription_matiere")
    public List<Inscription_Matiere> getAllInscription_Matiere() {
        return this.inscriptionMatiereService.getAllInscription_Matiere();
    }

    @GetMapping("/inscription_matiere/{id_eleves}")
    public Inscription_Matiere getInscription_MatiereById(@PathVariable int id_eleves) {
        return this.inscriptionMatiereService.getInscription_MatiereById(id_eleves);
    }

    @PostMapping("/inscription_matiere")
    public Inscription_Matiere createInscription_Matiere(@RequestBody Inscription_Matiere inscriptionMatiere) {
        return inscriptionMatiereService.createInscription_Matiere(inscriptionMatiere);
    }

    @PutMapping("/inscription_matiere/{id_eleves}")
    public Inscription_Matiere updateInscription_Matiere(@PathVariable int id_eleves, @RequestBody Inscription_Matiere inscriptionMatiere) {
        return inscriptionMatiereService.updateInscription_Matiere(id_eleves, inscriptionMatiere);
    }

    @DeleteMapping("/inscription_matiere/{id_eleves}")
    public String deleteInscription_Matiere(@PathVariable int id_eleves){
        return inscriptionMatiereService.deleteInscription_Matiere(id_eleves);
    }

}
