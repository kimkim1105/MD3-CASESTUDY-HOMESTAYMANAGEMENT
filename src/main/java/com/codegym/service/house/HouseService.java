package com.codegym.service.house;

import com.codegym.model.House;
import com.codegym.repository.BasicRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class HouseService implements IHouseService{
    BasicRepository basicRepository = new BasicRepository();
    @Override
    public List<House> findAll() {
        List<House> houses = new ArrayList<>();
        try (Connection connection = basicRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from house");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int typeID = rs.getInt("typeID");
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
                houses.add(new House(id,name,typeID,designstyle,address,maxpeople,basicUtilityId,standardId,status,image,price,description,extraUtilityId,evalue,countsOfOrder));

            }
        } catch (SQLException e) {

        }
        return houses;
    }

    @Override
    public void save(House house) throws SQLException {
        try (Connection connection = basicRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into house(name,typeId,designstyle,address,maxpeople,basicUtility,standardId,status,image,price,description,extraUtility,evalue,countsOfOrder) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)")){
            preparedStatement.setString(1,house.getName());
            preparedStatement.setInt(2,house.getTypeId());
            preparedStatement.setString(3,house.getDesignStyle());
            preparedStatement.setString(4,house.getAddress());
            preparedStatement.setInt(5,house.getMaxPeople());
            preparedStatement.setString(6,house.getBasicUtility());
            preparedStatement.setInt(7,house.getStandardId());
            preparedStatement.setString(8,house.getStatus());
            preparedStatement.setString(9,house.getImage());
            preparedStatement.setFloat(10,house.getPrice());
            preparedStatement.setString(11,house.getDescription());
            preparedStatement.setString(12,house.getExtraUtility());
            preparedStatement.setFloat(13,house.getEvalue());
            preparedStatement.setInt(14,house.getCountsOfOder());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {

        }
    }

    @Override
    public boolean update(House house) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = basicRepository.getConnection(); PreparedStatement statement = connection.prepareStatement("update house set name = ?,typeId = ?,designstyle = ?,address = ?,maxpeople = ?,basicUtility = ?,standardId = ?,status = ?,image = ?,price = ?,description = ?,extraUtility = ?,evalue = ?,countsOfOrder = ? where id = ?;");) {
            statement.setString(1, house.getName());
            statement.setInt(2, house.getTypeId());
            statement.setString(3, house.getDesignStyle());
            statement.setString(4, house.getAddress());
            statement.setInt(5, house.getMaxPeople());
            statement.setString(6, house.getBasicUtility());
            statement.setInt(7, house.getStandardId());
            statement.setString(8, house.getStatus());
            statement.setString(9, house.getImage());
            statement.setFloat(10, house.getPrice());
            statement.setString(11, house.getDescription());
            statement.setString(12, house.getExtraUtility());
            statement.setFloat(13, house.getEvalue());
            statement.setInt(14, house.getCountsOfOder());
            statement.setInt(15, house.getId());
            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }  return rowUpdated;
        }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = basicRepository.getConnection(); PreparedStatement statement = connection.prepareStatement("delete from house where id = ?");) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public House findById(int id) {
        House house = null;
        try(Connection connection = basicRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from house where id = ?");) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int typeID = rs.getInt("typeID");
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
                house = new House(id,name,typeID,designstyle,address,maxpeople,basicUtilityId,standardId,status,image,price,description,extraUtilityId,evalue,countsOfOrder);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return house;
    }

    @Override
    public List<House> findByName(String nameSearch) {
        List<House> houses = new ArrayList<>();
        try (Connection connection = basicRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("select*from house where name like ?");) {
            preparedStatement.setString(1, "%" + nameSearch + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int typeID = rs.getInt("typeID");
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
                houses.add(new House(id,name,typeID,designstyle,address,maxpeople,basicUtilityId,standardId,status,image,price,description,extraUtilityId,evalue,countsOfOrder));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return houses;
    }
}
