package com.epam.hospital.dao.impl;

import com.epam.hospital.dao.DepartmentDao;
import com.epam.hospital.dao.connectionpool.ConnectionPool;
import com.epam.hospital.dao.mapper.DepartmentMapper;
import com.epam.hospital.dto.DepartmentDto;
import com.epam.hospital.entity.Department;

import java.sql.*;

public class DepartmentDaoImpl implements DepartmentDao {
    public static final String INSERT_DEPARTMENT =
            "INSERT INTO hospital.departments (title, number_of_chambers, number_of_beds, head_doctors_id) VALUES (?, ?, ?, ?)";
    public static final String SELECT_LAST_INSERT_ID = "SELECT id FROM hospital.departments WHERE id = LAST_INSERT_ID()";
    public static final String SELECT_ALL_BY_DEPARTMENT_ID =
            "SELECT id, title, number_of_chambers, number_of_beds, head_doctors_id FROM hospital.departments WHERE id = ?";
    public static final String SELECT_ALL_BY_TITLE =
            "SELECT id, title, number_of_chambers, number_of_beds, head_doctors_id FROM hospital.departments WHERE title = ?";
    public static final String SELECT_ALL_BY_HEAD_DOCTOR_ID =
            "SELECT id, title, number_of_chambers, number_of_beds, head_doctors_id FROM hospital.departments WHERE head_doctors_id = ?";

    private ConnectionPool connectionPool;

    public DepartmentDaoImpl() {
        this.connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public Department insert(DepartmentDto departmentDto) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEPARTMENT);
            preparedStatement.setString(1, departmentDto.getTitle());
            preparedStatement.setInt(2, departmentDto.getChambersNumber());
            preparedStatement.setInt(3, departmentDto.getBedsNumber());
            preparedStatement.setInt(4, departmentDto.getHeadDoctorId());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_LAST_INSERT_ID);
            resultSet.next();
            return DepartmentMapper.toDepartment(resultSet.getInt(1), departmentDto);
        }
    }

    @Override
    public Department findById(int id) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_DEPARTMENT_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return DepartmentMapper.toDepartment(resultSet);
        }
    }

    @Override
    public Department findByTitle(String title) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_TITLE);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            return DepartmentMapper.toDepartment(resultSet);
        }
    }

    @Override
    public Department findByHeadDoctorsId(int headDoctorId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_HEAD_DOCTOR_ID);
            preparedStatement.setInt(1, headDoctorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return DepartmentMapper.toDepartment(resultSet);
        }
    }
}
