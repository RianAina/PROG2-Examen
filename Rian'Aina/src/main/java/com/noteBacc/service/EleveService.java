package com.noteBacc.service;

import com.noteBacc.model.Eleve;
import com.noteBacc.repository.EleveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Service
public class EleveService {
    private EleveRepository eleveRepository;

    public List<Eleve> getAllEtudiants(){
        try {
            return this.eleveRepository.getAllEdutiants();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Eleve getStudiantById(int id){
        try {
            return this.eleveRepository.getEtudiantById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    public Eleve createEleves(Eleve eleve){
        try {
            eleveRepository.createEleves(eleve);
            return eleve;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Eleve updateEtudiant(int id, Eleve eleve){
        try {
            eleve.setId(id);
            eleveRepository.updateEtudiant(id , eleve);
            return eleve;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteEtudiant(int id){
        try {
            eleveRepository.deleteEtudiant(id);
            return "Eleves effacé avec succes";
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
