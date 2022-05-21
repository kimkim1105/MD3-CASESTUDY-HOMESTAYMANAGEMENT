package com.codegym.service.standard;

import com.codegym.model.House;
import com.codegym.model.Standard;
import com.codegym.model.Type;
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
        Standard standard = null;
        try(Connection connection = basicRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from standard where id = ?");) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                standard = new Standard(id,name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return standard;
    }

    @Override
    public List<House> getHouseByIdStandardId(int standardId) {
        List<House> houses = new ArrayList<>();
        try (Connection connection = basicRepository.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from house where standardId = ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, standardId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String designstyle = rs.getString("designstyle");
                String address = rs.getString("address");
                int maxpeople = Integer.parseInt(rs.getString("maxpeople"));
                int typeId = Integer.parseInt(rs.getString("typeId"));
                String basicUtilityId = rs.getString("basicUtility");
                String status = rs.getString("status");
                String image = rs.getString("image");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                String extraUtilityId = rs.getString("extraUtility");
                float evalue = rs.getFloat("evalue");
                int countsOfOrder = rs.getInt("countsOfOrder");
                houses.add(new House(id,name,typeId,designstyle,address,maxpeople,basicUtilityId,standardId,status,image,price,description,extraUtilityId,evalue,countsOfOrder));

            }
        } catch (SQLException e) {

        }
        return houses;
    }

    @Override
    public List<Standard> findAllStandardfromHouses(List<House> houses) {
        List<Standard> standards = new ArrayList<>();
        try (Connection connection = basicRepository.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from standard join house on house.standardId = standard.id;");) {
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
}
