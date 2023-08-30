package com.noteBacc.service;

import com.noteBacc.model.Inscription_Matiere;
import com.noteBacc.repository.Inscription_MatiereRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@Service
public class Inscription_MatiereService {
    private Inscription_MatiereRepository inscriptionMatiereRepository;

    public List<Inscription_Matiere> getAllInscription_Matiere(){
        try {
            return this.inscriptionMatiereRepository.getAllInscription_Matiere();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Inscription_Matiere getInscription_MatiereById(int id_eleves){
        try {
            return this.inscriptionMatiereRepository.getInscription_MatiereById(id_eleves);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Inscription_Matiere createInscription_Matiere(Inscription_Matiere inscriptionMatiere){
        try {
            inscriptionMatiereRepository.createInscription_Matiere(inscriptionMatiere);
            return inscriptionMatiere;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Inscription_Matiere updateInscription_Matiere(int id_eleves, Inscription_Matiere inscriptionMatiere){
        try {
            inscriptionMatiere.setNote(id_eleves);
            inscriptionMatiereRepository.updateInscription_Matiere(id_eleves , inscriptionMatiere);
            return inscriptionMatiere;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteInscription_Matiere(int id_eleves){
        try {
            inscriptionMatiereRepository.deleteInscription_Matiere(id_eleves);
            return "Inscription au Bacc de l'id :"+ id_eleves +" effacé avec succes" ;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
