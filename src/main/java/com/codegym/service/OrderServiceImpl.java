package com.codegym.service;

import com.codegym.model.Orders;
import com.codegym.repository.BasicRepository;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements IOrderService{


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
