package com.noteBacc.repository;

import com.noteBacc.model.Eleve;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class EleveRepository {
    private Connection connection;
    public Eleve createNewInstance(ResultSet resultSet) throws  SQLException{
        return new Eleve(
            resultSet.getInt("id"),
            resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("serie"));
    }

    public void createEleves(Eleve eleve) throws SQLException {
        String sql = "INSERT INTO eleves " + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eleve.getId());
            statement.setString(2, eleve.getFirst_name());
            statement.setString(3, eleve.getLast_name());
            statement.setString(4, eleve.getSerie());
            statement.executeUpdate();
        }
    }
    public List<Eleve> getAllEdutiants() throws SQLException {
        String sql = "SELECT * FROM eleves";
        List<Eleve> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }


    public Eleve getEtudiantById(int id) throws SQLException {
        String sql = "SELECT * FROM eleves WHERE id = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;    }

    public void updateEtudiant(int id, Eleve eleve) throws SQLException {
        String sql = "UPDATE eleves SET first_name = ?, last_name = ?,serie = ? " +
                " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, eleve.getFirst_name());
            statement.setString(2, eleve.getLast_name());
            statement.setString(3, eleve.getSerie());
            statement.setInt(4, id);

            statement.executeUpdate();
        }
    }

    public void deleteEtudiant(int id) throws SQLException {
        String sql = "DELETE FROM eleves WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }

    }

}