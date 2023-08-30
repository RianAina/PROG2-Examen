package com.noteBacc.service;

import com.noteBacc.model.Matiere;
import com.noteBacc.repository.MatiereRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@Service
public class MatiereService {
    private MatiereRepository matiereRepository;

    public List<Matiere> getAllMatiere() {
        try {
            return this.matiereRepository.getAllMatiere();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Matiere getMatiereById(int id) {
        try {
            return this.matiereRepository.getMatiereById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Matiere createMatiere(Matiere matiere) {
        try {
            matiereRepository.createMatiere(matiere);
            return matiere;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Matiere updateMatiere(int id, Matiere matiere) {
        try {
            matiere.setId(id);
            matiereRepository.updateMatiere(id, matiere);
            return matiere;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteMatiere(int id) {
        try {
            matiereRepository.deleteMatiere(id);
            return "Matiere effacé avec succes";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
