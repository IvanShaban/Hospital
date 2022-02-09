package com.epam.hospital.dao;

import com.epam.hospital.dao.connectionpool.ConnectionPoolException;

import java.sql.SQLException;

public interface Dao<T, A> {
    T insert(A dto) throws SQLException, ConnectionPoolException;
    T findById(int id) throws SQLException;
}