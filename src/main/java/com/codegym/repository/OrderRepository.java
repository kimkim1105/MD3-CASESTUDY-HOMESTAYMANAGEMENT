package com.codegym.repository;

import com.codegym.model.Orders;

import java.sql.SQLException;
import java.util.List;

public class OrderRepository implements IOrderRepository{
    BasicRepository basicRepository = new BasicRepository();
    private static final String SELECT_ALL_ORDER = "SELECT fa.facility_id,\n" +
            "       fa.facility_code,\n" +
            "       fa.facility_name,\n" +
            "       fa.floor_square,\n" +
            "       fa.rental_fee,\n" +
            "       fa.maximum_people,\n" +
            "       fa.room_standard,\n" +
            "       fa.description,\n" +
            "       fa.pool_square,\n" +
            "       fa.floor,\n" +
            "       ft.value,\n" +
            "       rt.rent_type_name\n" +
            "FROM facility fa\n" +
            "         LEFT JOIN facility_type ft ON fa.facility_type_id = ft.facility_type_id\n" +
            "         LEFT JOIN rent_type rt ON fa.rent_type_id = rt.rent_type_id";

    private static final String INSERT_FACILITY = "INSERT INTO facility " +
            "(                     facility_code,\n" +
            "                      facility_name,\n" +
            "                      floor_square,\n" +
            "                      rental_fee,\n" +
            "                      maximum_people,\n" +
            "                      facility_type_id,\n" +
            "                      rent_type_id,\n" +
            "                      room_standard,\n" +
            "                      description,\n" +
            "                      pool_square,\n" +
            "                      floor)\n" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    @Override
    public List<Orders> findAll() {
        return null;
    }

    @Override
    public void save(Orders orders) throws SQLException {

    }

    @Override
    public void update(Orders orders) throws SQLException {

    }

    @Override
    public void delete(Orders orders) throws SQLException {

    }

    @Override
    public Orders findById(int id) {
        return null;
    }
}
