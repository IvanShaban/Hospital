package com.epam.hospital.dao.impl;

import com.epam.hospital.dao.DepartmentDao;
import com.epam.hospital.dto.DepartmentDto;
import com.epam.hospital.entity.Department;

import java.sql.*;

public class DepartmentDaoImpl implements DepartmentDao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/hospital";

    public Department insert(DepartmentDto departmentDto) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO departments (title, number_of_chambers, number_of_beds, head_doctors_id) " +
                            "VALUES ('" + departmentDto.getTitle() + "', '" + departmentDto.getChambersNumber() + "', '"
                            + departmentDto.getBedsNumber() + "', '" + departmentDto.getHeadDoctorId() + "')");
            ResultSet resultSet = statement.executeQuery("SELECT id from chambers where id = LAST_INSERT_ID()");
            resultSet.next();
            return new Department.Builder()
                    .id(resultSet.getInt(1))
                    .title(departmentDto.getTitle())
                    .chambersNumber(departmentDto.getChambersNumber())
                    .bedsNumber(departmentDto.getBedsNumber())
                    .setHeadDoctorId(departmentDto.getHeadDoctorId())
                    .build();
        }
    }

    public Department findById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, title, number_of_chambers, number_of_beds, head_doctors_id " +
                            "from departments where id = " + id);
            resultSet.next();
            return new Department.Builder()
                    .id(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .chambersNumber(resultSet.getInt(3))
                    .bedsNumber(resultSet.getInt(4))
                    .setHeadDoctorId(resultSet.getInt(5))
                    .build();
        }
    }

    public Department findByTitle(String title) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, title, number_of_chambers, number_of_beds, head_doctors_id " +
                            "from departments where title = " + title);
            resultSet.next();
            return new Department.Builder()
                    .id(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .chambersNumber(resultSet.getInt(3))
                    .bedsNumber(resultSet.getInt(4))
                    .setHeadDoctorId(resultSet.getInt(5))
                    .build();
        }
    }

    public Department findByHeadDoctorsId(int headDoctorId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, title, number_of_chambers, number_of_beds, head_doctors_id " +
                            "from departments where head_doctors_id = " + headDoctorId);
            resultSet.next();
            return new Department.Builder()
                    .id(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .chambersNumber(resultSet.getInt(3))
                    .bedsNumber(resultSet.getInt(4))
                    .setHeadDoctorId(resultSet.getInt(5))
                    .build();
        }
    }
}
