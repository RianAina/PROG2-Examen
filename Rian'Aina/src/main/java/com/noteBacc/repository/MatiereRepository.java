package com.noteBacc.repository;

import com.noteBacc.model.Matiere;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class MatiereRepository {
    private Connection connection;
    public Matiere createNewInstance(ResultSet resultSet) throws SQLException {
        return new Matiere(
                resultSet.getInt("id"),
                resultSet.getString("name"));
    }

    public List<Matiere> getAllMatiere() throws SQLException {
        String sql = "SELECT * FROM matiere";
        List<Matiere> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public Matiere getMatiereById(int id) throws SQLException {
        String sql = "SELECT * FROM matiere where id = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;    }


    public void createMatiere(Matiere matiere) throws SQLException {
        String sql = "INSERT INTO matiere " +"VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, matiere.getId());
            statement.setString(2, matiere.getName());
            statement.executeUpdate();
        }
    }

    public void updateMatiere(int id, Matiere matiere) throws SQLException {
        String sql = "UPDATE matiere SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, matiere.getName());
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    public void deleteMatiere(int id) throws SQLException {
        String sql = "DELETE FROM matiere WHERE  id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
