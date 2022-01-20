package com.epam.hospital.dao.impl;

import com.epam.hospital.dao.ChamberDao;
import com.epam.hospital.dao.mapper.ChamberMapper;
import com.epam.hospital.dto.ChamberDto;
import com.epam.hospital.entity.Chamber;

import java.sql.*;
import java.util.List;

public class ChamberDaoImpl implements ChamberDao {
    String USERNAME = "root";
    String PASSWORD = "root";
    String URL = "jdbc:mysql://localhost:3306/hospital";

    public Chamber insert(ChamberDto chamberDto) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO chambers (departments_id, number_of_beds) " +
                    "VALUES ('" + chamberDto.getDepartmentId() + "', '" + chamberDto.getBedsNumber() + "')");
            ResultSet resultSet = statement.executeQuery("SELECT id from chambers where id = LAST_INSERT_ID()");
            return ChamberMapper.toChamber(resultSet);
        }
    }

    public Chamber findById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, departments_id, number_of_beds from chambers where id = " + id);
            return ChamberMapper.toChamber(resultSet);
        }
    }

    public List<Chamber> findByDepartmentId(int departmentId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, departments_id, number_of_beds from chambers where departments_id = " + departmentId);
            return ChamberMapper.toChamberList(resultSet);
        }
    }
}
