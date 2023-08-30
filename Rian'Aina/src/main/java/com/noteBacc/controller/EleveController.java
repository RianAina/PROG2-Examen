package com.noteBacc.controller;

import com.noteBacc.service.EleveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EleveController {
    private EleveService eleveService;

    @GetMapping("/eleves")
    public List<com.noteBacc.model.Eleve> getAllEtudiants() {
        return this.eleveService.getAllEtudiants();
    }



    @GetMapping("/eleves/{id}")
    public com.noteBacc.model.Eleve getStudentsByStd(@PathVariable int id) {
        return this.eleveService.getStudiantById(id);
    }

    @PostMapping("/eleves")
    public com.noteBacc.model.Eleve createEleves(@RequestBody com.noteBacc.model.Eleve eleve) {
        return eleveService.createEleves(eleve);
    }

    @PutMapping("/eleves/{id}")
    public com.noteBacc.model.Eleve updateEtudiant(@PathVariable int id, @RequestBody com.noteBacc.model.Eleve eleve) {
        return eleveService.updateEtudiant(id, eleve);
    }

    @DeleteMapping("/eleves/{id}")
    public String deleteEtudiant(@PathVariable int id){
        return eleveService.deleteEtudiant(id);
    }
}
