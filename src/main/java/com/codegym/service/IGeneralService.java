package com.codegym.service;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    void save(T t) throws SQLException;
    boolean update(T t)throws SQLException;
    void delete(T t) throws SQLException;
    T findById(int id);
}
