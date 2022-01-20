package com.epam.hospital.dao;

import java.sql.SQLException;

public interface Dao<T, A> {
    T insert(A dto) throws SQLException;
    T findById(int id) throws SQLException;
}