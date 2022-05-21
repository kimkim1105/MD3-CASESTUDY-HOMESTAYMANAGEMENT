package com.codegym.service.type;

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

public class TypeService implements ITypeService{
     BasicRepository basicRepository = new BasicRepository();
    @Override
    public List<Type> findAll() {
        List<Type> types = new ArrayList<>();
        try (Connection connection = basicRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from type");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                types.add(new Type(id,name));

            }
        } catch (SQLException e) {

        }
        return types;
    }

    @Override
    public void save(Type type) throws SQLException {

    }

    @Override
    public boolean update(Type type) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Type findById(int id) {
        Type type = null;
        try(Connection connection = basicRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from type where id = ?");) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                type = new Type(id,name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return type;
    }

    @Override
    public List<House> getHouseByIdTypeId(int typeId) {
        List<House> houses = new ArrayList<>();
        try (Connection connection = basicRepository.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from house where typeId = ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, typeId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String designstyle = rs.getString("designstyle");
                String address = rs.getString("address");
                int maxpeople = Integer.parseInt(rs.getString("maxpeople"));
                String basicUtilityId = rs.getString("basicUtility");
                int standardId = Integer.parseInt(rs.getString("standardId"));
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
    public List<Type> findAllTypefromHouses(List<House> houses) {
        List<Type> types = new ArrayList<>();
        try (Connection connection = basicRepository.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from type join house on house.typeId = type.id;");) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                types.add(new Type(id,name));
            }
        } catch (SQLException e) {

        }
        return types;
    }
}
