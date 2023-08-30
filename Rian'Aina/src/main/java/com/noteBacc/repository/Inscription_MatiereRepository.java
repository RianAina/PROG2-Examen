package com.noteBacc.repository;

import com.noteBacc.model.Inscription_Matiere;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class Inscription_MatiereRepository {
    private Connection connection;
    public Inscription_Matiere createNewInstance (ResultSet resultSet) throws SQLException {
        return new Inscription_Matiere(
                resultSet.getInt("id_eleves"),
                resultSet.getInt("id_matiere"),
                resultSet.getInt("note")
                );
    }

    public List<Inscription_Matiere> getAllInscription_Matiere() throws SQLException {
        String sql = "SELECT * FROM inscription_Matiere";
        List<Inscription_Matiere> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public Inscription_Matiere getInscription_MatiereById(int id_eleves) throws SQLException {
        String sql = "SELECT * FROM inscription_Matiere WHERE id_eleves = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id_eleves);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;    }

    public void createInscription_Matiere(Inscription_Matiere inscriptionMatiere) throws SQLException {
        String sql = "INSERT INTO inscription_Matiere VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, inscriptionMatiere.getId_eleves());
            statement.setInt(2, inscriptionMatiere.getId_eleves());
            statement.setInt(3, inscriptionMatiere.getId_matiere());
            statement.setInt(4, inscriptionMatiere.getNote());
            statement.executeUpdate();
        }
    }

    public void updateInscription_Matiere(int id_eleves,Inscription_Matiere inscriptionMatiere) throws SQLException {
        String sql = "UPDATE inscription_Matiere SET id_matiere = ?, note =? WHERE id_eleves  = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,inscriptionMatiere.getId_matiere());
            statement.setInt(2, inscriptionMatiere.getNote());
            statement.setInt(3, inscriptionMatiere.getId_eleves());
            statement.executeUpdate();
        }
    }

    public void deleteInscription_Matiere(int id_eleves) throws SQLException {
        String sql = "DELETE FROM inscription_Matiere WHERE id_eleves = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_eleves);
            statement.executeUpdate();
        }
    }
}
