package com.codegym.repository;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();
    void save(T t) throws SQLException;
    void update(T t)throws SQLException;
    void delete(T t) throws SQLException;
    T findById(int id);
}
