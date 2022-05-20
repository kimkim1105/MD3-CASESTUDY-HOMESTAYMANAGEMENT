package com.codegym.service.standard;

import com.codegym.model.House;
import com.codegym.model.Standard;
import com.codegym.repository.BasicRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StandardService implements IStandardService{
    BasicRepository basicRepository = new BasicRepository();
    @Override
    public List<Standard> findAll() {
        List<Standard> standards = new ArrayList<>();
        try (Connection connection = basicRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from standard");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                standards.add(new Standard(id,name));

            }
        } catch (SQLException e) {

        }
        return standards;
    }

    @Override
    public void save(Standard standard) throws SQLException {

    }

    @Override
    public boolean update(Standard standard) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Standard findById(int id) {
        return null;
    }
}
